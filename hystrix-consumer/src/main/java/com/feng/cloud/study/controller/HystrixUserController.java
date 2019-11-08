package com.feng.cloud.study.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author: fengyantao
 * @date: 2019/11/6 下午4:26
 * @version: V1.0
 * @review: fengyantao/2019/11/6 下午4:26
 */
@RestController
@RequestMapping("/user")
public class HystrixUserController {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 获取电影列表
     *
     * @return
     */
    @GetMapping("/findMovies")
    @HystrixCommand(fallbackMethod = "hystrixFallBackMethod")
    public String findMovies() {
        ResponseEntity<String> forEntity = restTemplate
                .getForEntity("http://eureka-producer/producer/movie/test", String.class);
        String body = forEntity.getBody();
        return body;
    }

    /**
     * 服务调用失败时，会调用此方法
     *
     * @return
     */
    public String hystrixFallBackMethod() {
        return "ERROR";
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
