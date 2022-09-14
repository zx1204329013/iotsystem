package com.inmeasure.common.event;

import com.inmeasure.emqx.domain.TempAndHum;
import org.springframework.context.ApplicationEvent;

import java.time.Clock;

/**
 * 保存温湿度传感器类的事件
 */

public class TempAndHumEvent extends ApplicationEvent {
    private TempAndHum tempAndHum;
    public TempAndHumEvent(Object source) {
        super(source);
    }

    public TempAndHumEvent(Object source, TempAndHum tempAndHum) {
        super(source);
        this.tempAndHum = tempAndHum;
    }

    public TempAndHum getTempAndHum() {
        return tempAndHum;
    }

    public void setTempAndHum(TempAndHum tempAndHum) {
        this.tempAndHum = tempAndHum;
    }
}
