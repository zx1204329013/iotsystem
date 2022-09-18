package com.inmeasure.storage.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TempHumData {
    @TableId
    private Long deviceId;
    private String createTime;
    private Double tempVal;
    private Double humVal;
}
