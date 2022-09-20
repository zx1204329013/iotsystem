package com.inmeasure.common.event;

import com.inmeasure.emqx.domain.Ph;
import com.inmeasure.emqx.domain.Ws;
import org.springframework.context.ApplicationEvent;

/**
 * 保存二氧化碳传感器类的事件
 */

public class PhEvent extends ApplicationEvent {
    private Ph ph;
    public PhEvent(Object source) {
        super(source);
    }

    public PhEvent(Object source, Ph ph) {
        super(source);
        this.ph = ph;
    }

    public Ph getPh() {
        return ph;
    }

    public void setPh(Ph ph) {
        this.ph = ph;
    }
}
