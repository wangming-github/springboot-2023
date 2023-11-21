package com.example.springboot03;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.springboot03.mapper")
public class Springboot03 {

    public static void main(String[] args) {
        SpringApplication.run(Springboot03.class, args);
    }

}
