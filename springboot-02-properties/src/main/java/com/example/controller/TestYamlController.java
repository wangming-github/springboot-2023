package com.example.controller;

import com.example.priperties.CustomJsonConfig;
import com.example.priperties.CustomListConfig;
import com.example.priperties.CustomMapConfig;
import com.example.priperties.CustomUserConfig;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2023/11/12 17:06
 */

@RestController
public class TestYamlController {


    @Resource
    private CustomListConfig customListConfig;

    @Resource
    private CustomMapConfig customMapConfig;

    @Resource
    private CustomJsonConfig customJsonConfig;

    @Resource
    private CustomUserConfig customUserConfig;


    @PostConstruct
    private void doPostConstruct() {
        System.out.println("=====Test2Controller======");
        System.out.println(customListConfig);
        System.out.println(customMapConfig);
        System.out.println(customJsonConfig);
        System.out.println(customUserConfig);
    }
}
