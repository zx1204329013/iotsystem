package com.inmeasure.storage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.inmeasure.storage.domain.TempHumMgt;
import com.inmeasure.storage.domain.WsMgt;
import com.inmeasure.storage.mapper.TempHumMgtMapper;
import com.inmeasure.storage.mapper.WsMgtMapper;
import com.inmeasure.storage.service.TempHumMgtService;
import com.inmeasure.storage.service.WsMgtService;
import org.springframework.stereotype.Service;


@Service
public class WsMgtServiceImpl extends ServiceImpl<WsMgtMapper, WsMgt> implements WsMgtService {
}
