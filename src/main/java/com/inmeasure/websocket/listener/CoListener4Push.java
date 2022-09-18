package com.inmeasure.websocket.listener;

import com.inmeasure.common.event.AirprEvent;
import com.inmeasure.common.event.CoEvent;
import com.inmeasure.emqx.domain.AirPr;
import com.inmeasure.emqx.domain.Co;
import com.inmeasure.websocket.service.AirPrWebSocketService;
import com.inmeasure.websocket.service.CoWebSocketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 气压传感器推送消息监听器
 */
@Component
@Slf4j
public class CoListener4Push implements ApplicationListener<CoEvent> {
    /**
     * 推送消息方法
     * @param event
     */
    @Override
    @Async("taskExecutor")
    public void onApplicationEvent(CoEvent event) {
        Co co = event.getCo();
        String s = co.toString();
        log.info("二氧化碳传感器器消息推送监听器：" + s);
        CoWebSocketService.sendInfo(co);
    }
}
