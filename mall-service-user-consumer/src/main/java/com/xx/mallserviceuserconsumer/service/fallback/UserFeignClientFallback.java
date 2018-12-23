package com.xx.mallserviceuserconsumer.service.fallback;

import com.xx.mallserviceuserconsumer.service.UserFeignClient;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Component;

/**
 * Created by 余庚鑫 on 2018/12/23
 */
@Component
public class UserFeignClientFallback implements UserFeignClient {

    @Override
    public String login(String userName) {
        return "异常";
    }
}
