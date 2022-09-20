package com.inmeasure.common.event;

import com.inmeasure.emqx.domain.Co2AndVoc;
import com.inmeasure.emqx.domain.TempAndHum;
import org.springframework.context.ApplicationEvent;

/**
 * 保存温湿度传感器类的事件
 */

public class Co2AndVocEvent extends ApplicationEvent {
    private Co2AndVoc co2AndVoc;
    public Co2AndVocEvent(Object source) {
        super(source);
    }

    public Co2AndVocEvent(Object source, Co2AndVoc co2AndVoc) {
        super(source);
        this.co2AndVoc = co2AndVoc;
    }

    public Co2AndVoc getCo2AndVoc() {
        return co2AndVoc;
    }

    public void setCo2AndVoc(Co2AndVoc co2AndVoc) {
        this.co2AndVoc = co2AndVoc;
    }
}
