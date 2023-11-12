package com.example.priperties;

import com.example.config.YamlPropertySourceFactory;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component
@PropertySource(value = "classpath:test.yml", encoding = "utf-8", factory = YamlPropertySourceFactory.class)
@ConfigurationProperties(prefix = "custom.user")
public class CustomUserConfig {

    private Integer id;
    private String name;
    private Integer age;


}
