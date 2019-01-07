package com.humingfeng.eurekaclientfirst;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class EurekaClientFirstApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientFirstApplication.class, args);
    }



    @Value("${server.port}")
    String port;

    @RequestMapping("/home")
    public String home(@RequestParam(value = "name" , defaultValue = "first") String name) {
        return "hi,"+name+"i am from port:"+port;
    }

}

