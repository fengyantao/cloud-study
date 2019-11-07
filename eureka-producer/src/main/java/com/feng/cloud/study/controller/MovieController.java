package com.feng.cloud.study.controller;

import com.alibaba.fastjson.JSONObject;
import com.feng.cloud.study.entity.MovieVo;
import com.feng.cloud.study.mapper.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: fengyantao
 * @date: 2019/11/6 下午3:22
 * @version: V1.0
 * @review: fengyantao/2019/11/6 下午3:22
 */
@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/getAllMovies")
    public String getAllMovies() {
        List<MovieVo> voList = movieRepository.findAll();
        return JSONObject.toJSONString(voList);
    }

    @GetMapping("/test")
    public String testMovie() {

        return "SUCCESS";
    }
}
