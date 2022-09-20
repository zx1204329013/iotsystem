package com.inmeasure.emqx.controller;

import com.inmeasure.common.event.AirprEvent;
import com.inmeasure.common.event.CoEvent;
import com.inmeasure.common.event.TempAndHumEvent;
import com.inmeasure.emqx.domain.AirPr;
import com.inmeasure.emqx.domain.Co;
import com.inmeasure.emqx.domain.TempAndHum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;


/**
 * 负责接收EMQX服务器端的数据
 */
@Slf4j
@RestController
@RequestMapping("/emqx/webhook")
public class EmqxWebHook {
    //事件发送器
    @Autowired
    private ApplicationEventPublisher publisher;
    /**
     * 获取温湿度传感器数据
     * @param tempAndHum
     * @return
     */
    @PostMapping("/tempAndHum")
    public String getTempAndHum(@RequestBody TempAndHum tempAndHum){
        //发送事件，让监听器获取后进行数据存储、webSocket
        publisher.publishEvent(new TempAndHumEvent(this , tempAndHum));
        return null;
    }

    /**
     * 获取气压传感器的数据
     * @param airPr
     * @return
     */
    @PostMapping("/airPr")
    public String getAirPr(@RequestBody AirPr airPr){
        //发送事件，让监听器获取后进行数据存储、webSocket
        publisher.publishEvent(new AirprEvent(this , airPr));
        return null;
    }

    /**
     * 获取二氧化碳传感器数据
     * @param co
     * @return
     */
    @PostMapping("/co")
    public String getCo(@RequestBody Co co){
        //发送事件，让监听器获取后进行数据存储、webSocket
        publisher.publishEvent(new CoEvent(this , co));
        return null;
    }
}
