package com.inmeasure.storage.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.inmeasure.storage.domain.CoData;
import com.inmeasure.storage.domain.RainfallData;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RainfallDataMapper extends BaseMapper<RainfallData> {
}
