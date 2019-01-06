package com.xx.mallserverzuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by 余庚鑫 on 2018/12/23
 * PRE过滤器
 */

@Log4j2
@RefreshScope
@Component
public class PreFilter extends ZuulFilter {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @Value("${test}")
    private String test;

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        log.info("info:" + test);
        log.error("error:" + test);
//        log.info(MarkerEnum.KAFKA.getMarker(), "info:" + test);
//        log.error(MarkerEnum.KAFKA.getMarker(), "error:" + test);
        for (int i = 0 ;i< 10 ;i++){
//            kafkaTemplate.send("mall-server-zuul","mall","hello:"+i);
        }
        return null;
    }
}
