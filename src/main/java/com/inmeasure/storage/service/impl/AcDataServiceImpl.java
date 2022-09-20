package com.inmeasure.storage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.inmeasure.storage.domain.AcData;
import com.inmeasure.storage.domain.AirprData;
import com.inmeasure.storage.mapper.AcDataMapper;
import com.inmeasure.storage.mapper.AirprDataMapper;
import com.inmeasure.storage.service.AcDataService;
import com.inmeasure.storage.service.AirprDataService;
import org.springframework.stereotype.Service;

@Service
public class AcDataServiceImpl extends ServiceImpl<AcDataMapper, AcData> implements AcDataService {
}
