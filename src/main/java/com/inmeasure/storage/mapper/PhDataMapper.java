package com.inmeasure.storage.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.inmeasure.storage.domain.CoData;
import com.inmeasure.storage.domain.PhData;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PhDataMapper extends BaseMapper<PhData> {
}
