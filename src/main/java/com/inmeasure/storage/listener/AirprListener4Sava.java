package com.inmeasure.storage.listener;

import com.inmeasure.common.event.AirprEvent;
import com.inmeasure.common.event.TempAndHumEvent;
import com.inmeasure.emqx.domain.AirPr;
import com.inmeasure.emqx.domain.TempAndHum;
import com.inmeasure.storage.domain.AirprData;
import com.inmeasure.storage.domain.AirprMgt;
import com.inmeasure.storage.domain.TempHumData;
import com.inmeasure.storage.domain.TempHumMgt;
import com.inmeasure.storage.service.AirprDataService;
import com.inmeasure.storage.service.AirprMgtService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
public class AirprListener4Sava implements ApplicationListener<AirprEvent> {
    @Autowired
    private AirprMgtService airprMgtService;
    @Autowired
    private AirprDataService airprDataService;

    /**
     * 监听到气压传感器数据后，将设备信息以及设备气压数据保存至对应表中
     * @param event
     */
    @Async("taskExecutor")
    @Transactional
    public void onApplicationEvent(AirprEvent event) {
        log.info("气压传感器器消息存储监听器：" + event.toString());
        AirPr airPr = event.getAirPr();
        AirprData airprData = new AirprData();
        AirprMgt airprMgt = new AirprMgt();
        //将温度传感器的数据拷贝到设备信息实体类和设备数据实体类中
        BeanUtils.copyProperties(airPr , airprMgt);
        BeanUtils.copyProperties(airPr , airprData);
        //获取当前设备信息，如果不存在那么就插入，如果存在那么就更新
        AirprMgt apm = airprMgtService.getById(airprMgt.getDeviceId());
        if(apm == null){
            airprMgtService.save(airprMgt);
        }else{
            airprMgtService.updateById(airprMgt);
        }
        airprDataService.save(airprData);
    }
}
