package com.inmeasure.websocket.listener;

import com.inmeasure.common.event.AcEvent;
import com.inmeasure.common.event.CoEvent;
import com.inmeasure.emqx.domain.Ac;
import com.inmeasure.emqx.domain.Co;
import com.inmeasure.websocket.service.AcWebSocketService;
import com.inmeasure.websocket.service.CoWebSocketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 加速度传感器推送消息监听器
 */
@Component
@Slf4j
public class AcListener4Push implements ApplicationListener<AcEvent> {
    /**
     * 推送消息方法
     * @param event
     */
    @Override
    @Async("taskExecutor")
    public void onApplicationEvent(AcEvent event) {
        Ac ac = event.getAc();
        AcWebSocketService.sendInfo(ac);
    }
}
