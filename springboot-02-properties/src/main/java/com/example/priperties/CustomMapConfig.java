package com.example.priperties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Map;

/**
 * 自定义Map配置
 * 指定配置文件 classpath:/就是resource文件下
 *
 * @author maizi
 * @date 2023/11/13
 */
@Data
@Configuration
@PropertySource(value = "classpath:test.yml")
@ConfigurationProperties(prefix = "custom.map")
public class CustomMapConfig {

    /**
     * 值
     */
    private Map<String, String> value;

}
