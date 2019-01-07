package com.humingfeng.eurekaserverfirst;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaServerFirstApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerFirstApplication.class, args);
    }

}

