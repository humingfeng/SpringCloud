package com.humingfeng.feign.controller;

import com.humingfeng.feign.service.SchedualServiceHome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 胡铭锋
 * @ClassName HomeController
 * @description
 * @Date 2019/1/9 0:16
 * @Version 1.0
 **/

@RestController
public class HomeController {


    @Autowired
    SchedualServiceHome schedualServiceHome;

    @GetMapping("/home")
    public String home(@RequestParam String name) {
        return schedualServiceHome.accessServiceHome(name);
    }

}
