package com.inmeasure.common.event;

import com.inmeasure.emqx.domain.AirPr;
import com.inmeasure.emqx.domain.TempAndHum;
import org.springframework.context.ApplicationEvent;

/**
 * 保存气压传感器类的事件
 */

public class AirprEvent extends ApplicationEvent {
    private AirPr airPr;
    public AirprEvent(Object source) {
        super(source);
    }

    public AirprEvent(Object source, AirPr airPr) {
        super(source);
        this.airPr = airPr;
    }

    public AirPr getAirPr() {
        return airPr;
    }

    public void setAirPr(AirPr airPr) {
        this.airPr = airPr;
    }
}
