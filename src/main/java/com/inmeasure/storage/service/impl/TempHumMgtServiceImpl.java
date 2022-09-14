package com.inmeasure.storage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.inmeasure.storage.domain.TempHumMgt;
import com.inmeasure.storage.mapper.TempHumMgtMapper;
import com.inmeasure.storage.service.TempHumMgtService;
import org.springframework.stereotype.Service;


@Service
public class TempHumMgtServiceImpl extends ServiceImpl<TempHumMgtMapper, TempHumMgt> implements TempHumMgtService {
}
