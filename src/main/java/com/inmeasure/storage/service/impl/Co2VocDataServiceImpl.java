package com.inmeasure.storage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.inmeasure.storage.domain.Co2VocData;
import com.inmeasure.storage.domain.CoData;
import com.inmeasure.storage.mapper.Co2VocDataMapper;
import com.inmeasure.storage.mapper.CoDataMapper;
import com.inmeasure.storage.service.Co2VocDataService;
import com.inmeasure.storage.service.CoDataService;
import org.springframework.stereotype.Service;

@Service
public class Co2VocDataServiceImpl extends ServiceImpl<Co2VocDataMapper, Co2VocData> implements Co2VocDataService {
}
