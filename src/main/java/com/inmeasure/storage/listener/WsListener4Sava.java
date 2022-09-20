package com.inmeasure.storage.listener;

import com.inmeasure.common.event.CoEvent;
import com.inmeasure.common.event.WsEvent;
import com.inmeasure.emqx.domain.Co;
import com.inmeasure.emqx.domain.Ws;
import com.inmeasure.storage.domain.CoData;
import com.inmeasure.storage.domain.CoMgt;
import com.inmeasure.storage.domain.WsData;
import com.inmeasure.storage.domain.WsMgt;
import com.inmeasure.storage.service.CoDataService;
import com.inmeasure.storage.service.CoMgtService;
import com.inmeasure.storage.service.WsDataService;
import com.inmeasure.storage.service.WsMgtService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
public class WsListener4Sava implements ApplicationListener<WsEvent> {
    @Autowired
    private WsMgtService wsMgtService;
    @Autowired
    private WsDataService wsDataService;

    /**
     * 监听到气压传感器数据后，将设备信息以及设备气压数据保存至对应表中
     * @param event
     */
    @Async("taskExecutor")
    @Transactional
    public void onApplicationEvent(WsEvent event) {
        Ws ws = event.getWs();
        WsData wsData = new WsData();
        WsMgt wsMgt = new WsMgt();
        //将温度传感器的数据拷贝到设备信息实体类和设备数据实体类中
        BeanUtils.copyProperties(ws , wsData);
        BeanUtils.copyProperties(ws , wsMgt);
        //获取当前设备信息，如果不存在那么就插入，如果存在那么就更新
        WsMgt wm = wsMgtService.getById(wsMgt.getDeviceId());
        if(wm == null){
            wsMgtService.save(wsMgt);
        }else{
            wsMgtService.updateById(wsMgt);
        }
        wsDataService.save(wsData);
    }
}
