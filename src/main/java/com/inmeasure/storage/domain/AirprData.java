package com.inmeasure.storage.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AirprData {
    private Long deviceId;
    private String createTime;
    private Double AirprVal;
}
