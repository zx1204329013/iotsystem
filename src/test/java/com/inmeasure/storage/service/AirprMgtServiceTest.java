package com.inmeasure.storage.service;


import com.inmeasure.storage.domain.AirprMgt;
import com.inmeasure.storage.domain.TempHumMgt;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;

@SpringBootTest
public class AirprMgtServiceTest {
    @Autowired
    private AirprMgtService airprMgtService;
    @Test
    public void insert() throws ParseException {
        AirprMgt airprMgt = new AirprMgt("2022-09-13 22:12:10.270", new Long(1002), "SHT20", "西安长安区", 3);
        airprMgtService.save(airprMgt);
    }

    @Test
    public void selectById(){
        AirprMgt byId = airprMgtService.getById(1002);
        System.out.println(byId.toString());
    }
}
