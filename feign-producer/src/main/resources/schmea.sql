create table MOVIE(

uuid varchar (32) not null  COMMENT '主键',
name varchar (32) DEFAULT null COMMENT '电影名',
price varchar (11) DEFAULT null COMMENT '价格',
time  varchar (20) DEFAULT null COMMENT '放映时间',
primary key(uuid)

)ENGINE=InnoDB DEFAULT CHARSET=utf8;
