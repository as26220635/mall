package com.xx.mallserversleuth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import zipkin2.server.internal.EnableZipkinServer;

@EnableZipkinServer
@EnableEurekaClient
@SpringBootApplication
public class MallServerSleuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallServerSleuthApplication.class, args);
    }

}

