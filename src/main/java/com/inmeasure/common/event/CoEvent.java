package com.inmeasure.common.event;

import com.inmeasure.emqx.domain.AirPr;
import com.inmeasure.emqx.domain.Co;
import org.springframework.context.ApplicationEvent;

/**
 * 保存二氧化碳传感器类的事件
 */

public class CoEvent extends ApplicationEvent {
    private Co co;
    public CoEvent(Object source) {
        super(source);
    }

    public CoEvent(Object source, Co co) {
        super(source);
        this.co = co;
    }

    public Co getCo() {
        return co;
    }

    public void setCo(Co co) {
        this.co = co;
    }
}
