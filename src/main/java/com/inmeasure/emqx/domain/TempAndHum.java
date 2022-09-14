package com.inmeasure.emqx.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TempAndHum {
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS", timezone = "GMT+8")
    private String createTime;
    private Long deviceId;
    private String deviceType;
    private String deviceLocation;
    private String deviceStatus;
    private Double tempData;
    private Double humData;
}
