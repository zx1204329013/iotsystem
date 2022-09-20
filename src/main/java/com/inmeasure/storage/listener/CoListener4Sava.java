package com.inmeasure.storage.listener;

import com.inmeasure.common.event.AirprEvent;
import com.inmeasure.common.event.CoEvent;
import com.inmeasure.emqx.domain.AirPr;
import com.inmeasure.emqx.domain.Co;
import com.inmeasure.storage.domain.AirprData;
import com.inmeasure.storage.domain.AirprMgt;
import com.inmeasure.storage.domain.CoData;
import com.inmeasure.storage.domain.CoMgt;
import com.inmeasure.storage.service.AirprDataService;
import com.inmeasure.storage.service.AirprMgtService;
import com.inmeasure.storage.service.CoDataService;
import com.inmeasure.storage.service.CoMgtService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
public class CoListener4Sava implements ApplicationListener<CoEvent> {
    @Autowired
    private CoMgtService coMgtService;
    @Autowired
    private CoDataService coDataService;

    /**
     * 监听到气压传感器数据后，将设备信息以及设备气压数据保存至对应表中
     * @param event
     */
    @Async("taskExecutor")
    @Transactional
    public void onApplicationEvent(CoEvent event) {
        Co co = event.getCo();
        CoData coData = new CoData();
        CoMgt coMgt = new CoMgt();
        //将温度传感器的数据拷贝到设备信息实体类和设备数据实体类中
        BeanUtils.copyProperties(co , coData);
        BeanUtils.copyProperties(co , coMgt);
        //获取当前设备信息，如果不存在那么就插入，如果存在那么就更新
        CoMgt cm = coMgtService.getById(coMgt.getDeviceId());
        if(cm == null){
            coMgtService.save(coMgt);
        }else{
            coMgtService.updateById(coMgt);
        }
        coDataService.save(coData);
    }
}
