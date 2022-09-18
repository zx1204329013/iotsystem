package com.inmeasure.storage.service;


import com.inmeasure.storage.domain.AirprMgt;
import com.inmeasure.storage.domain.CoMgt;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;

@SpringBootTest
public class CoMgtServiceTest {
    @Autowired
    private CoMgtService coMgtService;
    @Test
    public void insert() throws ParseException {
        CoMgt coMgt = new CoMgt("2022-09-13 22:12:10.270", new Long(1002), "SHT20", "西安长安区", 3);
        coMgtService.save(coMgt);
    }

    @Test
    public void selectById(){
        CoMgt byId = coMgtService.getById(1002);
        System.out.println(byId.toString());
    }
}
