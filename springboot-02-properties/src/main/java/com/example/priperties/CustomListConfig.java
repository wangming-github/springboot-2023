package com.example.priperties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 自定义List配置
 *
 * @author maizi
 * @version 1.0
 * @author: MaiZi
 * @date: 2023/11/12 17:33
 * @date 2023/11/13
 */
@Data
@Component
@PropertySource(value = "classpath:test.yml")
@ConfigurationProperties(prefix = "custom.list")
public class CustomListConfig {

    /**
     * 值
     */
    private List<String> value;
}