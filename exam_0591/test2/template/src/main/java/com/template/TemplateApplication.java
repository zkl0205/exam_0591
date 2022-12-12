package com.template;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Date: Created in 2019-03-12 11:29
 * Utils: Intellij Idea
 * Description: 启动类
 */
@SpringBootApplication
@MapperScan("com.template.mapper")
public class TemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(TemplateApplication.class, args);
    }

}
