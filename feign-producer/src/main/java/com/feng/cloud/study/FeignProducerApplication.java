package com.feng.cloud.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = { "com.feng.cloud.study.feignApi" })
public class FeignProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignProducerApplication.class, args);
    }

}
