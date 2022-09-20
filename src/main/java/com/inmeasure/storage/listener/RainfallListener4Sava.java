package com.inmeasure.storage.listener;

import com.inmeasure.common.event.CoEvent;
import com.inmeasure.common.event.RainfallEvent;
import com.inmeasure.emqx.domain.Co;
import com.inmeasure.emqx.domain.Rainfall;
import com.inmeasure.storage.domain.CoData;
import com.inmeasure.storage.domain.CoMgt;
import com.inmeasure.storage.domain.RainfallData;
import com.inmeasure.storage.domain.RainfallMgt;
import com.inmeasure.storage.service.CoDataService;
import com.inmeasure.storage.service.CoMgtService;
import com.inmeasure.storage.service.RainfallDataService;
import com.inmeasure.storage.service.RainfallMgtService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
public class RainfallListener4Sava implements ApplicationListener<RainfallEvent> {
    @Autowired
    private RainfallMgtService rainfallMgtService;
    @Autowired
    private RainfallDataService rainfallDataService;

    /**
     * 监听到雨量传感器数据后，将设备信息以及设备气压数据保存至对应表中
     * @param event
     */
    @Async("taskExecutor")
    @Transactional
    public void onApplicationEvent(RainfallEvent event) {
        Rainfall rainfall = event.getRainfall();
        RainfallData rainfallData = new RainfallData();
        RainfallMgt rainfallMgt = new RainfallMgt();
        //将温度传感器的数据拷贝到设备信息实体类和设备数据实体类中
        BeanUtils.copyProperties(rainfall , rainfallData);
        BeanUtils.copyProperties(rainfall , rainfallMgt);
        //获取当前设备信息，如果不存在那么就插入，如果存在那么就更新
        RainfallMgt rfm = rainfallMgtService.getById(rainfallMgt.getDeviceId());
        if(rfm == null){
            rainfallMgtService.save(rainfallMgt);
        }else{
            rainfallMgtService.updateById(rainfallMgt);
        }
        rainfallDataService.save(rainfallData);
    }
}
