package com.xx.mallserviceuserconsumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by 余庚鑫 on 2018/12/23
 */
@FeignClient(name = "mall-service-user-provider")
public interface UserFeignClient {

    /**
     * 测试
     *
     * @param userName
     * @return
     */
    @PostMapping("/login")
    String login(String userName);
}
