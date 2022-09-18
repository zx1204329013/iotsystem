package com.inmeasure.storage.service;

import com.inmeasure.storage.domain.AirprData;
import com.inmeasure.storage.domain.TempHumData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AirprDataServiceTest {
    @Autowired
    private AirprDataService airprDataService;
    @Test
    public void insert(){
        AirprData airprData = new AirprData(new Long(1001), "2022-09-13 22:12:10.270",
                20.2);
        boolean save = airprDataService.save(airprData);
    }
}
