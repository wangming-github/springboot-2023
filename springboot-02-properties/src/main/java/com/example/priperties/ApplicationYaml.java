package com.example.priperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 应用程序yaml测试
 *
 * @author maizi
 * @version 1.0
 * @author: MaiZi
 * @date: 2023/11/11 23:21
 * @date 2023/11/13
 */

@Component
@Setter     //setter方法一定不能少 因为你从配置文件中拿到的数据必须通过setter方法才能赋值给对象
@Getter
@ToString
@ConfigurationProperties("student")
public class ApplicationYaml {

    /**
     * id
     */
    private int id;
    /**
     * 名称
     */
    private String name;
    /**
     * 年龄
     */
    private int age;


}
