package com.humingfeng.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 胡铭锋
 * @ClassName SchedualService
 * @description
 * @Date 2019/1/9 0:10
 * @Version 1.0
 **/

@FeignClient(value = "eureka-client-first",fallback = SchedualServiceHomeHystrix.class)
public interface SchedualServiceHome {

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    String accessServiceHome(@RequestParam(value = "name") String name);

}
