package com.inmeasure.storage.listener;

import com.inmeasure.common.event.AcEvent;
import com.inmeasure.common.event.CoEvent;
import com.inmeasure.emqx.domain.Ac;
import com.inmeasure.emqx.domain.Co;
import com.inmeasure.storage.domain.AcData;
import com.inmeasure.storage.domain.AcMgt;
import com.inmeasure.storage.domain.CoData;
import com.inmeasure.storage.domain.CoMgt;
import com.inmeasure.storage.service.AcDataService;
import com.inmeasure.storage.service.AcMgtService;
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
public class AcListener4Sava implements ApplicationListener<AcEvent> {
    @Autowired
    private AcMgtService acMgtService;
    @Autowired
    private AcDataService acDataService;

    /**
     * 监听到加速度传感器数据后，将设备信息以及设备气压数据保存至对应表中
     * @param event
     */
    @Async("taskExecutor")
    @Transactional
    public void onApplicationEvent(AcEvent event) {
        Ac ac = event.getAc();
        AcData acData = new AcData();
        AcMgt acMgt = new AcMgt();
        //将温度传感器的数据拷贝到设备信息实体类和设备数据实体类中
        BeanUtils.copyProperties(ac , acData);
        BeanUtils.copyProperties(ac , acMgt);
        //获取当前设备信息，如果不存在那么就插入，如果存在那么就更新
        AcMgt am = acMgtService.getById(acMgt.getDeviceId());
        if(am == null){
            acMgtService.save(acMgt);
        }else{
            acMgtService.updateById(acMgt);
        }
        acDataService.save(acData);
    }
}
