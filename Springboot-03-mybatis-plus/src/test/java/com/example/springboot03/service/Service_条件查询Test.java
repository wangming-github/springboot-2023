package com.example.springboot03.service;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2023/11/20 02:16
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class Service_条件查询Test {

    @Resource
    Service_条件查询 service;

    @Test
    void 查询所有() {
        service.查询所有();
    }

    @Test
    void 条件用Map进行封装() {
        service.条件用Map进行封装();
    }

    @Test
    void 条件用列名等于值() {
        service.条件用列名等于值();
    }


    @Test
    void 条件用列名不等于OR大于小于小于等于等() {
        service.条件用列名不等于OR大于小于小于等于等();
    }

    @Test
    void 条件用年龄在或不在18到25之间() {
        service.条件用年龄在或不在18到25之间();
    }

    @Test
    void 模糊查询like或notLike() {
        service.模糊查询like或notLike();
    }

    @Test
    void 模糊查询左边界匹配或右边界匹配() {
        service.模糊查询左边界匹配或右边界匹配();
    }

    @Test
    void 空值查询或非空值查询() {
        service.空值查询或非空值查询();
    }

    @Test
    void 姓名是张三或李四的用户或者姓名不是张三或李四的用户() {
        service.姓名是张三或李四的用户或者姓名不是张三或李四的用户();
    }

    @Test
    void 在SQL语句的查询结果中进行查询() {
        service.在SQL语句的查询结果中进行查询();
    }

    @Test
    void 分组() {
        service.分组();
    }

    @Test
    void 排序() {
        service.排序();
    }

    @Test
    void 或者OR并且() {
        service.或者OR并且();
    }

    @Test
    void 存在或者不存在() {
        service.存在或者不存在();
    }
}