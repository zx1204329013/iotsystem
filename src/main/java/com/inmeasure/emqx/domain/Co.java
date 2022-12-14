package com.inmeasure.emqx.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Co {
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS", timezone = "GMT+8")
    private String createTime;
    private Long deviceId;
    private String deviceType;
    private String deviceLocation;
    private Integer deviceStatus;
    private Double coVal;
}
