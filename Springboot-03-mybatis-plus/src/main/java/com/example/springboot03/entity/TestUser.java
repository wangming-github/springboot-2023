package com.example.springboot03.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

//使用lombok 简化getset方法
@Data
@TableName("user_test1")
public class TestUser {

    @TableId
    private Integer id;

    // 用户名
    private String username;

    // 年龄
    private Integer age;

    // 电话号码
    private Integer tel;

    // 创建时间
    private Date createTime;

    // 更新时间
    private Date updateTime;

    // 版本号
    private Integer version;
}
