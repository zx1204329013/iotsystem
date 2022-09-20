package com.inmeasure.storage.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.inmeasure.storage.domain.TempHumData;
import com.inmeasure.storage.domain.WsData;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WsDataMapper extends BaseMapper<WsData> {
}
