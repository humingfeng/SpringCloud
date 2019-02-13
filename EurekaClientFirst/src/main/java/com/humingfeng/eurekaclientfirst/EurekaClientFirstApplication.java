package com.humingfeng.eurekaclientfirst;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
@EnableHystrix
@EnableHystrixDashboard
@EnableCircuitBreaker
public class EurekaClientFirstApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientFirstApplication.class, args);
    }



    @Value("${server.port}")
    String port;

    @RequestMapping("/home")
    @HystrixCommand(fallbackMethod = "homeError")
    public String home(@RequestParam(value = "name" , defaultValue = "first") String name) {
        return "hi,"+name+"i am from port:"+port;
    }

    public String homeError(String name) {
        return "hi,"+name+",sorry,error!";
    }
}

