package com.humingfeng.feign.service;

import org.springframework.stereotype.Component;

@Component
public class SchedualServiceHomeHystrix implements SchedualServiceHome{

    @Override
    public String accessServiceHome(String name) {
        return "sorry!name:"+name;
    }

}
