package com.inmeasure.common.event;

import com.inmeasure.emqx.domain.Ac;
import com.inmeasure.emqx.domain.Co;
import org.springframework.context.ApplicationEvent;

/**
 * 保存加速度传感器类的事件
 */

public class AcEvent extends ApplicationEvent {
    private Ac ac;
    public AcEvent(Object source) {
        super(source);
    }

    public AcEvent(Object source, Ac ac) {
        super(source);
        this.ac = ac;
    }

    public Ac getAc() {
        return ac;
    }

    public void setAc(Ac ac) {
        this.ac = ac;
    }
}
