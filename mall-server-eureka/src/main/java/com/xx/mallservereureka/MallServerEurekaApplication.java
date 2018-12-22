package com.xx.mallservereureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MallServerEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallServerEurekaApplication.class, args);
    }

}

