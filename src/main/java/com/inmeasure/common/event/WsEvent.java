package com.inmeasure.common.event;

import com.inmeasure.emqx.domain.Co;
import com.inmeasure.emqx.domain.Ws;
import org.springframework.context.ApplicationEvent;

/**
 * 保存二氧化碳传感器类的事件
 */

public class WsEvent extends ApplicationEvent {
    private Ws ws;
    public WsEvent(Object source) {
        super(source);
    }

    public WsEvent(Object source, Ws ws) {
        super(source);
        this.ws = ws;
    }

    public Ws getWs() {
        return ws;
    }

    public void setWs(Ws ws) {
        this.ws = ws;
    }
}
