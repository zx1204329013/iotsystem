package com.inmeasure.websocket.listener;

import com.inmeasure.common.event.CoEvent;
import com.inmeasure.common.event.PhEvent;
import com.inmeasure.emqx.domain.Co;
import com.inmeasure.emqx.domain.Ph;
import com.inmeasure.websocket.service.CoWebSocketService;
import com.inmeasure.websocket.service.PhWebSocketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 水质传感器推送消息监听器
 */
@Component
@Slf4j
public class PhListener4Push implements ApplicationListener<PhEvent> {
    /**
     * 推送消息方法
     * @param event
     */
    @Override
    @Async("taskExecutor")
    public void onApplicationEvent(PhEvent event) {
        Ph ph = event.getPh();
        PhWebSocketService.sendInfo(ph);
    }
}
