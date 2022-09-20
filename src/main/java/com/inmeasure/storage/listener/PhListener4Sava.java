package com.inmeasure.storage.listener;

import com.inmeasure.common.event.CoEvent;
import com.inmeasure.common.event.PhEvent;
import com.inmeasure.emqx.domain.Co;
import com.inmeasure.emqx.domain.Ph;
import com.inmeasure.storage.domain.CoData;
import com.inmeasure.storage.domain.CoMgt;
import com.inmeasure.storage.domain.PhData;
import com.inmeasure.storage.domain.PhMgt;
import com.inmeasure.storage.service.CoDataService;
import com.inmeasure.storage.service.CoMgtService;
import com.inmeasure.storage.service.PhDataService;
import com.inmeasure.storage.service.PhMgtService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
public class PhListener4Sava implements ApplicationListener<PhEvent> {
    @Autowired
    private PhMgtService phMgtService;
    @Autowired
    private PhDataService phDataService;

    /**
     * 监听到水质传感器数据后，将设备信息以及设备气压数据保存至对应表中
     * @param event
     */
    @Async("taskExecutor")
    @Transactional
    public void onApplicationEvent(PhEvent event) {
        Ph ph = event.getPh();
        PhData phData = new PhData();
        PhMgt phMgt = new PhMgt();
        //将温度传感器的数据拷贝到设备信息实体类和设备数据实体类中
        BeanUtils.copyProperties(ph , phData);
        BeanUtils.copyProperties(ph , phMgt);
        //获取当前设备信息，如果不存在那么就插入，如果存在那么就更新
        PhMgt pm = phMgtService.getById(phMgt.getDeviceId());
        if(pm == null){
            phMgtService.save(phMgt);
        }else{
            phMgtService.updateById(phMgt);
        }
        phDataService.save(phData);
    }
}
