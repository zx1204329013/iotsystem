package com.inmeasure.websocket.listener;

import com.inmeasure.common.event.TempAndHumEvent;
import com.inmeasure.emqx.domain.TempAndHum;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class TempAndHumListener4Push implements ApplicationListener<TempAndHumEvent> {
    @Override
    @Async("taskExecutor")
    public void onApplicationEvent(TempAndHumEvent event) {
        TempAndHum tempAndHum = event.getTempAndHum();
        String s = tempAndHum.toString();
        System.out.println("推送消息监听器监听到消息：" + s);
    }
}
