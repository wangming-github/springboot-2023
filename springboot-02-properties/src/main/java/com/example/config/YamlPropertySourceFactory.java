package com.example.config;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;

import java.util.Properties;

/**
 * 如果想要 @PropertySource 读取 .yml 格式的文件需要自定义 YamlPropertySourceFactory
 *
 * @author maizi
 */
public class YamlPropertySourceFactory implements PropertySourceFactory {

    @Override
    public PropertySource<?> createPropertySource(String name, EncodedResource encodedResource) {

        Resource resource = encodedResource.getResource();

        YamlPropertiesFactoryBean factory = new YamlPropertiesFactoryBean();
        factory.setResources(resource);

        Properties props = factory.getObject();

        return new PropertiesPropertySource(resource.getFilename(), props);
    }
}
