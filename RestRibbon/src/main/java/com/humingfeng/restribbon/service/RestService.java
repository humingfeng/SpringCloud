package com.humingfeng.restribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author 胡铭锋
 * @ClassName RestService
 * @description
 * @Date 2019/1/8 0:02
 * @Version 1.0
 **/
@Service
public class RestService {

    @Autowired
    private RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "homeError")
    public String getHomeService(String name) {
        return restTemplate.getForObject("http://eureka-client-first/home?name="+name,String.class);
    }


    public String homeError(String name) {
        return "hi,"+name+",sorry,error!notice:hystrix";
    }
}
