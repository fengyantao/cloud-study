package com.feng.cloud.study.controller;

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
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/findMovies")
    public String findMovies() {
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:8802/producer/movie/test", String.class);
        String body = forEntity.getBody();
        return body;
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
