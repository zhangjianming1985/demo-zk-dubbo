package com.zjm;

import org.apache.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@SpringBootApplication
@EnableDubboConfig
public class ConsumerApplication {
    public static void main(String[] arg){
        SpringApplication.run(ConsumerApplication.class,arg);
    }
}
