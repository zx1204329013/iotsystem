package com.inmeasure.storage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.inmeasure.storage.domain.AirprMgt;
import com.inmeasure.storage.domain.CoMgt;
import com.inmeasure.storage.mapper.AirprMgtMapper;
import com.inmeasure.storage.mapper.CoMgtMapper;
import com.inmeasure.storage.service.AirprMgtService;
import com.inmeasure.storage.service.CoMgtService;
import org.springframework.stereotype.Service;


@Service
public class CoMgtServiceImpl extends ServiceImpl<CoMgtMapper, CoMgt> implements CoMgtService {
}
