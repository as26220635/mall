package com.xx.mallserviceuserprovider.service;

import com.xx.mallserviceuserconsumer.service.UserFeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 余庚鑫 on 2018/12/23
 */
@RestController
public class UserService implements UserFeignClient {


    @PostMapping("/login")
    @Override
    public String login(@RequestParam("userName") String userName) {
        return "用户:" + userName;
    }
}
