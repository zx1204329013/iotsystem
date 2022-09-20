package com.inmeasure.storage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.inmeasure.storage.domain.CoMgt;
import com.inmeasure.storage.domain.RainfallMgt;
import com.inmeasure.storage.mapper.CoMgtMapper;
import com.inmeasure.storage.mapper.RainfallMgtMapper;
import com.inmeasure.storage.service.CoMgtService;
import com.inmeasure.storage.service.RainfallMgtService;
import org.springframework.stereotype.Service;


@Service
public class RainfallMgtServiceImpl extends ServiceImpl<RainfallMgtMapper, RainfallMgt> implements RainfallMgtService {
}
