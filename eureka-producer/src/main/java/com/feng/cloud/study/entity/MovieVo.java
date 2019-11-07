package com.feng.cloud.study.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author: fengyantao
 * @date: 2019/9/26 下午9:49
 * @version: V1.0
 * @review: fengyantao/2019/9/26 下午9:49
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity(name = "movie")
public class MovieVo implements Serializable {

    private static final long serialVersionUID = -6799861275124457101L;
    @Id
    private String uuid;

    private String name;

    private String price;

    private String time;
}
