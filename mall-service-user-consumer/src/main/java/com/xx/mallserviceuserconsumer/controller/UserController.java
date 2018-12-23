package com.xx.mallserviceuserconsumer.controller;

import com.netflix.discovery.converters.Auto;
import com.xx.mallserviceuserconsumer.service.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Action;

/**
 * Created by 余庚鑫 on 2018/12/23
 */
@RestController
public class UserController {

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/login")
    public String login(String name) {
        return "结果:" + userFeignClient.login(name);
    }
}
