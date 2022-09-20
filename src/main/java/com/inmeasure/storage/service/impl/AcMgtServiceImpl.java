package com.inmeasure.storage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.inmeasure.storage.domain.AcMgt;
import com.inmeasure.storage.domain.AirprMgt;
import com.inmeasure.storage.mapper.AcMgtMapper;
import com.inmeasure.storage.mapper.AirprMgtMapper;
import com.inmeasure.storage.service.AcMgtService;
import com.inmeasure.storage.service.AirprMgtService;
import org.springframework.stereotype.Service;


@Service
public class AcMgtServiceImpl extends ServiceImpl<AcMgtMapper, AcMgt> implements AcMgtService {
}
