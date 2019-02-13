package com.humingfeng.zipkinclientfirst;

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
public class ZipkinClientFirstApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinClientFirstApplication.class, args);
    }

    private static final Logger logger = Logger.getLogger(ZipkinClientFirstApplication.class.getName());

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
        return restTemplate.getForObject("http://localhost:8989/info",String.class);
    }

    @RequestMapping("/info")
    public String info() {
        return "i am first";
    }
}

