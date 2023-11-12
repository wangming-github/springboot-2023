package com.example.priperties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2023/11/12 01:37
 */
@Data
@Component
@PropertySource("classpath:test.yml")
@ConfigurationProperties(prefix = "custom.json")
public class CustomJsonConfig {

    private Integer age;
    private String name;
}
