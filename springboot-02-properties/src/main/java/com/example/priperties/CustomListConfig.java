package com.example.priperties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2023/11/12 17:33
 */
@Data
@Component
@PropertySource(value = "classpath:test.yml")
@ConfigurationProperties(prefix = "custom.list")
public class CustomListConfig {

    List<String> value;
}