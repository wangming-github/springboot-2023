package com.example.controller;

import com.example.priperties.ApplicationProperties;
import com.example.priperties.ApplicationYaml;
import com.example.priperties.CustomJsonConfig;
import com.example.priperties.TestPropertiesUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Arrays;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2023/11/11 23:16
 */
@Controller
@ResponseBody
public class TestProController {

    /*
     * properties 是以 key=value 的形式配置的键值类型的配置文件，而 yml 使用的是类似 json 格式的树形配置⽅式进⾏配置的，yml 层级之间使用换行缩进的方式配置，key 和 value 之间使用“: ”英文冒号加空格的方式设置，并且空格不可省略；
     * properties 为早期并且默认的配置文件格式，但其配置存在⼀定的冗余数据，使用 yml 可以很好的解决数据冗余的问题；
     * yml 通用性更好，支持更多语言，如 Java、Go、Python 等，如果是云服务器开发，可以使用⼀份配置文件作为 Java 和 Go 的共同配置文件；yml 支持更多的数据类型.
     */

    /**
     * 需要定义一个变量 目的就是把从配置文件中读取到的内容赋值给这个变量
     */
    @Value("${server.port}")
    private int port;

    @Value("${String.str1}")
    private String str1;
    @Value("${String.str2}")
    private String str2;
    @Value("${String.str3}")
    private String str3;
    @Value("${custom.array.value}")
    private String[] arrayValue;

    @Autowired
    private ApplicationYaml applicationYaml;
    @Resource
    private ApplicationProperties applicationProperties;
    @Resource
    private TestPropertiesUser userProperties;

    @Resource
    private CustomJsonConfig animalYamlJson;


    @RequestMapping("/sayHi")
    public String sayHi() {
        return "hello world port -> " + port;
    }

    /**
     * 注意：
     * <p>
     * 字符串默认不用加上单引号或者双引号；
     * 单引号会转义特殊字符，特殊字符最终只是一个普通的字符串数据；
     * 双引号不会转义字符串里面的特殊字符，特殊字符会作为本身想表示的意思.
     */
    @PostConstruct
    public void doPostConstruct() {
        System.out.println("========");
        System.out.println(applicationYaml);
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
        System.out.println(applicationProperties);
        System.out.println(userProperties);
        System.out.println(animalYamlJson);
        System.out.println(Arrays.toString(arrayValue));


    }


}
