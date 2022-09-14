package com.inmeasure.storage.mapper;

import com.inmeasure.storage.domain.TempHumMgt;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TempHumMgtMapperTest {
    @Autowired
    private TempHumMgtMapper tempHumMgtMapper;
    @Test
    public void selectById(){
        TempHumMgt tempHumMgt = tempHumMgtMapper.selectById(1001);
        System.out.println(tempHumMgt.toString());
    }
}
