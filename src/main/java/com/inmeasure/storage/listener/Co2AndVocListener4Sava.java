package com.inmeasure.storage.listener;

import com.inmeasure.common.event.Co2AndVocEvent;
import com.inmeasure.common.event.CoEvent;
import com.inmeasure.emqx.domain.Co;
import com.inmeasure.emqx.domain.Co2AndVoc;
import com.inmeasure.storage.domain.Co2VocData;
import com.inmeasure.storage.domain.Co2VocMgt;
import com.inmeasure.storage.domain.CoData;
import com.inmeasure.storage.domain.CoMgt;
import com.inmeasure.storage.service.Co2VocDataService;
import com.inmeasure.storage.service.Co2VocMgtService;
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
public class Co2AndVocListener4Sava implements ApplicationListener<Co2AndVocEvent> {
    @Autowired
    private Co2VocMgtService co2VocMgtService;
    @Autowired
    private Co2VocDataService co2VocDataService;

    /**
     * 监听到气压传感器数据后，将设备信息以及设备气压数据保存至对应表中
     * @param event
     */
    @Async("taskExecutor")
    @Transactional
    public void onApplicationEvent(Co2AndVocEvent event) {
        Co2AndVoc co2AndVoc = event.getCo2AndVoc();
        Co2VocData co2VocData = new Co2VocData();
        Co2VocMgt co2VocMgt = new Co2VocMgt();
        //将温度传感器的数据拷贝到设备信息实体类和设备数据实体类中
        BeanUtils.copyProperties(co2AndVoc , co2VocData);
        BeanUtils.copyProperties(co2AndVoc , co2VocMgt);
        //获取当前设备信息，如果不存在那么就插入，如果存在那么就更新
        Co2VocMgt cvm = co2VocMgtService.getById(co2VocMgt.getDeviceId());
        if(cvm == null){
            co2VocMgtService.save(co2VocMgt);
        }else{
            co2VocMgtService.updateById(co2VocMgt);
        }
        co2VocDataService.save(co2VocData);
    }
}
