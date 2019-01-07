package com.humingfeng.eurekaclientfirst;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaClientFirstApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientFirstApplication.class, args);
    }

}

