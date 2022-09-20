package com.inmeasure.storage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.inmeasure.storage.domain.CoData;
import com.inmeasure.storage.domain.RainfallData;
import com.inmeasure.storage.mapper.CoDataMapper;
import com.inmeasure.storage.mapper.RainfallDataMapper;
import com.inmeasure.storage.service.CoDataService;
import com.inmeasure.storage.service.RainfallDataService;
import org.springframework.stereotype.Service;

@Service
public class RainfallDataServiceImpl extends ServiceImpl<RainfallDataMapper, RainfallData> implements RainfallDataService {
}
