package com.inmeasure.storage.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TempHumData {
    private Long deviceId;
    private String createTime;
    private Double tempData;
    private Double humData;
}
