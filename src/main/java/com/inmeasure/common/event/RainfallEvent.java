package com.inmeasure.common.event;

import com.inmeasure.emqx.domain.Co;
import com.inmeasure.emqx.domain.Rainfall;
import org.springframework.context.ApplicationEvent;

/**
 * 保存二氧化碳传感器类的事件
 */

public class RainfallEvent extends ApplicationEvent {
    private Rainfall rainfall;
    public RainfallEvent(Object source) {
        super(source);
    }

    public RainfallEvent(Object source, Rainfall rainfall) {
        super(source);
        this.rainfall = rainfall;
    }

    public Rainfall getRainfall() {
        return rainfall;
    }

    public void setRainfall(Rainfall rainfall) {
        this.rainfall = rainfall;
    }
}
