package com.inmeasure.storage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.inmeasure.storage.domain.TempHumMgt;
import com.inmeasure.storage.domain.WsMgt;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WsMgtMapper extends BaseMapper<WsMgt> {
}
