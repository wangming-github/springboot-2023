package com.example.priperties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component
@PropertySource("classpath:test.properties")
@ConfigurationProperties(prefix = "user.b")
public class TestPropertiesUser {

    private String name;
    private Integer age;
    private String address;
}
