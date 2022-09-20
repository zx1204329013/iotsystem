package com.inmeasure.storage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.inmeasure.storage.domain.CoData;
import com.inmeasure.storage.domain.PhData;
import com.inmeasure.storage.mapper.CoDataMapper;
import com.inmeasure.storage.mapper.PhDataMapper;
import com.inmeasure.storage.service.CoDataService;
import com.inmeasure.storage.service.PhDataService;
import org.springframework.stereotype.Service;

@Service
public class PhDataServiceImpl extends ServiceImpl<PhDataMapper, PhData> implements PhDataService {
}
