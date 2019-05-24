package com.join.learn.ssm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author Join 2019-05-23
 */
//@ImportResource({"classpath*:/lambda-config/applicationContext-mybatis.xml"})
//@SpringBootApplication(scanBasePackages = {"com.nongfadai.lambda", "com.nongfadai.larva.*"})
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
