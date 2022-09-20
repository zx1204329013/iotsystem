package com.inmeasure.websocket.listener;

import com.inmeasure.common.event.CoEvent;
import com.inmeasure.common.event.RainfallEvent;
import com.inmeasure.emqx.domain.Co;
import com.inmeasure.emqx.domain.Rainfall;
import com.inmeasure.websocket.service.CoWebSocketService;
import com.inmeasure.websocket.service.RainfallWebSocketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 雨量传感器推送消息监听器
 */
@Component
@Slf4j
public class RainfallListener4Push implements ApplicationListener<RainfallEvent> {
    /**
     * 推送消息方法
     * @param event
     */
    @Override
    @Async("taskExecutor")
    public void onApplicationEvent(RainfallEvent event) {
        Rainfall rainfall = event.getRainfall();
        RainfallWebSocketService.sendInfo(rainfall);
    }
}
