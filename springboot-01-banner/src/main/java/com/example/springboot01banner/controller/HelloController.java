package com.example.springboot01banner.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2023/11/11 22:22
 */
@RestController
public class HelloController {

    @Value("${my.name}")
    private String name;

    @RequestMapping("/")
    public String index() {
        System.out.println("index......");
        return "index name:" + name;
    }
}
