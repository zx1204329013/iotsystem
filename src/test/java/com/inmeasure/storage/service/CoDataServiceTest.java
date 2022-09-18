package com.inmeasure.storage.service;

import com.inmeasure.storage.domain.AirprData;
import com.inmeasure.storage.domain.CoData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CoDataServiceTest {
    @Autowired
    private CoDataService coDataService;
    @Test
    public void insert(){
        CoData coData = new CoData(new Long(1001), "2022-09-13 22:12:10.270",
                20.2);
        boolean save = coDataService.save(coData);
    }
}
