package com.feng.cloud.study.mapper;

import com.feng.cloud.study.entity.MovieVo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author: fengyantao
 * @date: 2019/9/26 下午9:48
 * @version: V1.0
 * @review: fengyantao/2019/9/26 下午9:48
 */
public interface MovieRepository extends JpaRepository<MovieVo, String> {

    List<MovieVo> findAll();
}
