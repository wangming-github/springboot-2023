package com.example.priperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2023/11/11 23:21
 */

@Component
@Setter     //setter方法一定不能少 因为你从配置文件中拿到的数据必须通过setter方法才能赋值给对象
@Getter
@ToString
@ConfigurationProperties("student")
public class ApplicationYaml {

    private int id;
    private String name;
    private int age;


}
