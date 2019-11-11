package com.feng.cloud.study.feignClienImpl;

import com.alibaba.fastjson.JSONObject;
import com.feng.cloud.study.feignApi.MovieClient;
import com.feng.cloud.study.mapper.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: fengyantao
 * @date: 2019/11/11 下午5:34
 * @version: V1.0
 * @review: fengyantao/2019/11/11 下午5:34
 */
@Service
public class MovieClientImpl implements MovieClient {
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public String getAllMovies() {
        return JSONObject.toJSONString(movieRepository.findAll());
    }
}
