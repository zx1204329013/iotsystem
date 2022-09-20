package com.inmeasure.websocket.listener;

import com.inmeasure.common.event.CoEvent;
import com.inmeasure.common.event.WsEvent;
import com.inmeasure.emqx.domain.Co;
import com.inmeasure.emqx.domain.Ws;
import com.inmeasure.websocket.service.CoWebSocketService;
import com.inmeasure.websocket.service.WsWebSocketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 气压传感器推送消息监听器
 */
@Component
@Slf4j
public class WsListener4Push implements ApplicationListener<WsEvent> {
    /**
     * 推送消息方法
     * @param event
     */
    @Override
    @Async("taskExecutor")
    public void onApplicationEvent(WsEvent event) {
        Ws ws = event.getWs();
        WsWebSocketService.sendInfo(ws);
    }
}
