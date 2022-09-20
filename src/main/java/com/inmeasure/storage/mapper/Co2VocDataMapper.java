package com.inmeasure.storage.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.inmeasure.storage.domain.Co2VocData;
import com.inmeasure.storage.domain.TempHumData;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Co2VocDataMapper extends BaseMapper<Co2VocData> {
}
