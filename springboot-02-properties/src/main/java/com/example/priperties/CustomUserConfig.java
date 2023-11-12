package com.example.priperties;

import com.example.config.YamlPropertySourceFactory;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 自定义用户配置
 *
 * @author maizi
 * @date 2023/11/13
 */
@Data
@Component
@PropertySource(value = "classpath:test.yml", encoding = "utf-8", factory = YamlPropertySourceFactory.class)
@ConfigurationProperties(prefix = "custom.user")
public class CustomUserConfig {

    /**
     * id
     */
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;


}
