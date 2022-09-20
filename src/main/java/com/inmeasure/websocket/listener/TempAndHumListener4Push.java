package com.inmeasure.websocket.listener;

import com.inmeasure.common.event.TempAndHumEvent;
import com.inmeasure.emqx.domain.TempAndHum;
import com.inmeasure.websocket.service.TempHumWebSocketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 温度传感器推送消息监听器
 */
@Component
@Slf4j
public class TempAndHumListener4Push implements ApplicationListener<TempAndHumEvent> {
    /**
     * 推送消息方法
     * @param event
     */
    @Override
    @Async("taskExecutor")
    public void onApplicationEvent(TempAndHumEvent event) {
        TempAndHum tempAndHum = event.getTempAndHum();
        TempHumWebSocketService.sendInfo(tempAndHum);
    }
}
