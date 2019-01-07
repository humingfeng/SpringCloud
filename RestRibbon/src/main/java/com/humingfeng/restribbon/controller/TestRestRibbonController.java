package com.humingfeng.restribbon.controller;

import com.humingfeng.restribbon.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 胡铭锋
 * @ClassName TestRestRibbonController
 * @description
 * @Date 2019/1/8 0:06
 * @Version 1.0
 **/
@RestController
public class TestRestRibbonController {


    @Autowired
    RestService restService;

    @GetMapping("/home")
    public String getHomeService(@RequestParam String name) {

        return restService.getHomeService(name);

    }

}
