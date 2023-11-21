package com.example.springboot03.controller;

import com.example.springboot03.entity.TestUser;
import com.example.springboot03.service.Service_条件查询;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2023/11/20 01:08
 */
@RestController
@RequestMapping("User")
public class UserController {


    @Resource
    private Service_条件查询 service;

    /**
     * 查询所有用户信息
     */
    @GetMapping("/all")
    public List<TestUser> getAllUser() {
        return service.查询所有();
    }

}
