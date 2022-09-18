package com.inmeasure.storage.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.inmeasure.storage.domain.AirprData;
import com.inmeasure.storage.domain.CoData;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CoDataMapper extends BaseMapper<CoData> {
}
