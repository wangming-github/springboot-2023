package com.example.priperties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 应用程序属性
 *
 * @author maizi
 * @version 1.0
 * @author: MaiZi
 * @date: 2023/11/12 01:22
 * @date 2023/11/13
 */
@Data
@Component
@ConfigurationProperties(prefix = "zhangsan")
public class ApplicationProperties {

    private String xingbie;
    private String nianling;
}
