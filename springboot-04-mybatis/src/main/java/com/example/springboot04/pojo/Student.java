package com.example.springboot04.pojo;

import lombok.Data;

import java.util.Date;

/**
 * 学生表和专业表两张数据表，并假设一个学生只有一个专业
 */
@Data
public class Student {

    private Integer id;
    // 名字
    private String name;
    // 生日
    private Date birthday;
    // 电话号码
    private String phonenum;
    // 专业
    private Integer mid;
}
