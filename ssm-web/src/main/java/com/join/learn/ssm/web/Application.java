package com.join.learn.ssm.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;

/**
 * @author Join 2019-05-23
 */
@ImportResource({"classpath*:/applicationContext-mybatis.xml"})
@SpringBootApplication(scanBasePackages={"com.join.learn.ssm.*"})
public class Application /*extends SpringBootServletInitializer */{

    /*@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }*/

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
