package com.example.springboot04.pojo;

import lombok.Data;

/**
 * 学生表和专业表两张数据表，并假设一个学生只有一个专业
 */
@Data
public class Major {
    private Integer mid;
    private String mname;
}
