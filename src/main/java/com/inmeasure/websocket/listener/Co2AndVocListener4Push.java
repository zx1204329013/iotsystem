package com.inmeasure.websocket.listener;

import com.inmeasure.common.event.Co2AndVocEvent;
import com.inmeasure.common.event.CoEvent;
import com.inmeasure.emqx.domain.Co;
import com.inmeasure.emqx.domain.Co2AndVoc;
import com.inmeasure.websocket.service.Co2VocWebSocketService;
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
public class Co2AndVocListener4Push implements ApplicationListener<Co2AndVocEvent> {
    /**
     * 推送消息方法
     * @param event
     */
    @Override
    @Async("taskExecutor")
    public void onApplicationEvent(Co2AndVocEvent event) {
        Co2AndVoc co2AndVoc = event.getCo2AndVoc();
        Co2VocWebSocketService.sendInfo(co2AndVoc);
    }
}
