package com.inmeasure.storage.service;


import com.inmeasure.storage.domain.TempHumMgt;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
public class TempHumMgtServiceTest {
    @Autowired
    private TempHumMgtService tempHumMgtService;
    @Test
    public void insert() throws ParseException {
        TempHumMgt tempAndHumMgt = new TempHumMgt("2022-09-13 22:12:10.270", new Long(1002), "SHT20", "西安长安区", "正常");
        boolean save = tempHumMgtService.save(tempAndHumMgt);
    }

    @Test
    public void selectById(){
        TempHumMgt byId = tempHumMgtService.getById(1002);
        System.out.println(byId.toString());
    }
}
