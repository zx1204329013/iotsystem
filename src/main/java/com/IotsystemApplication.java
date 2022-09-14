package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.inmeasure.storage.mapper")
public class IotsystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(IotsystemApplication.class, args);
    }

}
