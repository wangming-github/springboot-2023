package com.example.priperties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 自定义json配置
 *
 * @author maizi
 * @version 1.0
 * @author: MaiZi
 * @date: 2023/11/12 01:37
 * @date 2023/11/13
 */
@Data
@Component
@PropertySource("classpath:test.yml")
@ConfigurationProperties(prefix = "custom.json")
public class CustomJsonConfig {

    /**
     * 年龄
     */
    private Integer age;
    /**
     * 名称
     */
    private String name;
}
