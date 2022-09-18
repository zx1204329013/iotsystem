package com.inmeasure.storage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.inmeasure.storage.domain.AirprData;
import com.inmeasure.storage.domain.TempHumData;
import com.inmeasure.storage.mapper.AirprDataMapper;
import com.inmeasure.storage.mapper.TempHumDataMapper;
import com.inmeasure.storage.service.AirprDataService;
import com.inmeasure.storage.service.TempHumDataService;
import org.springframework.stereotype.Service;

@Service
public class AirprDataServiceImpl extends ServiceImpl<AirprDataMapper, AirprData> implements AirprDataService {
}
