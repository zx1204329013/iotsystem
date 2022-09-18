package com.inmeasure.storage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.inmeasure.storage.domain.AirprData;
import com.inmeasure.storage.domain.CoData;
import com.inmeasure.storage.mapper.AirprDataMapper;
import com.inmeasure.storage.mapper.CoDataMapper;
import com.inmeasure.storage.service.AirprDataService;
import com.inmeasure.storage.service.CoDataService;
import org.springframework.stereotype.Service;

@Service
public class CoDataServiceImpl extends ServiceImpl<CoDataMapper, CoData> implements CoDataService {
}
