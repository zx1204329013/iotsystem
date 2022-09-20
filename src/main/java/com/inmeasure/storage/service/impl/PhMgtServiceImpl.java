package com.inmeasure.storage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.inmeasure.storage.domain.CoMgt;
import com.inmeasure.storage.domain.PhMgt;
import com.inmeasure.storage.mapper.CoMgtMapper;
import com.inmeasure.storage.mapper.PhMgtMapper;
import com.inmeasure.storage.service.CoMgtService;
import com.inmeasure.storage.service.PhMgtService;
import org.springframework.stereotype.Service;


@Service
public class PhMgtServiceImpl extends ServiceImpl<PhMgtMapper, PhMgt> implements PhMgtService {
}
