package com.inmeasure.storage.service;

import com.inmeasure.storage.domain.TempHumData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TempHumDataServiceTest {
    @Autowired
    private TempHumDataService tempHumDataService;
    @Test
    public void insert(){
        TempHumData tempHumData = new TempHumData(new Long(10001) , "2022-09-13 22:12:10.270" ,
                20.2 , 60.4);
        boolean save = tempHumDataService.save(tempHumData);
    }
}
