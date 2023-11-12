package com.example.priperties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Map;

/**
 * 指定配置文件 classpath:/就是resource文件下
 *
 * @author maizi
 */
@Data
@Configuration
@PropertySource(value = "classpath:test.yml")
@ConfigurationProperties(prefix = "custom.map")
public class CustomMapConfig {

    Map<String, String> value;

}
