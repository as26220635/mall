package com.xx.mallserviceuserconsumer.service;

import com.xx.mallserviceuserconsumer.service.fallback.UserFeignClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by 余庚鑫 on 2018/12/23
 */
@FeignClient(name = "mall-service-user-provider", fallback = UserFeignClientFallback.class)
public interface UserFeignClient {

    /**
     * 测试
     *
     * @param userName
     * @return
     */
    @PostMapping("/login")
    String login(@RequestParam("userName") String userName);
}
