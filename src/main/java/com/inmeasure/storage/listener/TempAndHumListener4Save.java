package com.inmeasure.storage.listener;

import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.inmeasure.common.event.TempAndHumEvent;
import com.inmeasure.emqx.domain.TempAndHum;
import com.inmeasure.storage.domain.TempHumData;
import com.inmeasure.storage.domain.TempHumMgt;
import com.inmeasure.storage.service.TempHumDataService;
import com.inmeasure.storage.service.TempHumMgtService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
public class TempAndHumListener4Save implements ApplicationListener<TempAndHumEvent> {
    @Autowired
    private TempHumMgtService tempHumMgtService;
    @Autowired
    private TempHumDataService tempHumDataService;

    /**
     * 监听到温湿度传感器数据后，将设备信息以及设备温湿度数据保存至对应表中
     * @param event
     */
    @Async("taskExecutor")
    @Transactional
    public void onApplicationEvent(TempAndHumEvent event) {
        TempAndHum tempAndHum = event.getTempAndHum();
        TempHumMgt tempHumMgt = new TempHumMgt();
        TempHumData tempAndHumData = new TempHumData();
        //将温度传感器的数据拷贝到设备信息实体类和设备数据实体类中
        BeanUtils.copyProperties(tempAndHum , tempHumMgt);
        BeanUtils.copyProperties(tempAndHum , tempAndHumData);
        //获取当前设备信息，如果不存在那么就插入，如果存在那么就更新
        TempHumMgt thm = tempHumMgtService.getById(tempHumMgt.getDeviceId());
        if(thm == null){
            tempHumMgtService.save(tempHumMgt);
        }else{
            tempHumMgtService.updateById(tempHumMgt);
        }
        tempHumDataService.save(tempAndHumData);
    }
}
