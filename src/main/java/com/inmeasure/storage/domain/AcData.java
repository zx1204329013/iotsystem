package com.inmeasure.storage.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AcData {
    @TableId
    private Long deviceId;
    private String createTime;
    private Double AcVal;
}
