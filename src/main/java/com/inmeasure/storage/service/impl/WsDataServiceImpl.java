package com.inmeasure.storage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.inmeasure.storage.domain.TempHumData;
import com.inmeasure.storage.domain.WsData;
import com.inmeasure.storage.mapper.TempHumDataMapper;
import com.inmeasure.storage.mapper.WsDataMapper;
import com.inmeasure.storage.service.TempHumDataService;
import com.inmeasure.storage.service.WsDataService;
import org.springframework.stereotype.Service;

@Service
public class WsDataServiceImpl extends ServiceImpl<WsDataMapper, WsData> implements WsDataService {
}
