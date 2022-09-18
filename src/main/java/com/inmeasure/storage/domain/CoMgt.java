package com.inmeasure.storage.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoMgt {
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS", timezone = "GMT+8")
    private String createTime;
    @TableId
    private Long deviceId;
    private String deviceType;
    private String deviceLocation;
    private Integer deviceStatus;

}
