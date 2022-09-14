package com.inmeasure.storage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.inmeasure.storage.domain.TempHumData;
import com.inmeasure.storage.mapper.TempHumDataMapper;
import com.inmeasure.storage.service.TempHumDataService;
import org.springframework.stereotype.Service;

@Service
public class TempHumDataServiceImpl extends ServiceImpl<TempHumDataMapper,TempHumData> implements TempHumDataService{
}
