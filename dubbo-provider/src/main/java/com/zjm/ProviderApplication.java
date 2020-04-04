package com.zjm;

import org.apache.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@SpringBootApplication
@EnableDubboConfig
public class ProviderApplication {
    public static void main(String[] args){
        ApplicationContext acx =SpringApplication.run(ProviderApplication.class,args);
    }
}
