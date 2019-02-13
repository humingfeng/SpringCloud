package com.humingfeng.zipkinclientsecond;

import brave.sampler.Sampler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@SpringBootApplication
@RestController
public class ZipkinClientSecondApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinClientSecondApplication.class, args);
    }


    private static final Logger logger = Logger.getLogger(ZipkinClientSecondApplication.class.getName());

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }

    @RequestMapping("/home")
    public String callFirst(){
        return "i am second";

    }

    @RequestMapping("/info")
    public String info() {
        return restTemplate.getForObject("http://localhost:8988/info",String.class);
    }

}

