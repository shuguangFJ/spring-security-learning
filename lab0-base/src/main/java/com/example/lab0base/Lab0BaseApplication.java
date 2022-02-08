package com.example.lab0base;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.lab0base.mapper")
public class Lab0BaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lab0BaseApplication.class, args);
    }

}
