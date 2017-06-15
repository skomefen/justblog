# 这是一个博客



### 技术栈

* web层spring-mvc 4
* 中间服务层，自己随便写一个吧
* 额。。。持久层，DButil,c3p0
* 视图：jsp+Bootstrap
* 版本控制git
* 项目构架maven
* 数据库mysql



### 功能

* 目前先做出登陆界面和博客主页吧，以后可能会转型为论坛


## 数据库表


    create  database  justblog; 

    create table user(

        id varchar(40) primary key,
        username varchar(40) not null,
        password varchar(40) not null,
        nickname varchar(40) not null,
        email varchar(40) not null,
        phone varchar(40) 
    
    );
    
    CREATE TABLE `post` (
      `id` varchar(40) NOT NULL,
      `title` varchar(255) NOT NULL,
      `thumbnail` varchar(255) DEFAULT NULL,
      `postClass` varchar(40) NOT NULL,
      `description` varchar(255) DEFAULT NULL,
      `udate` datetime NOT NULL,
      `user_id` varchar(40) NOT NULL,
      `contextAddress` varchar(255) NOT NULL,
      `author` varchar(255) DEFAULT NULL,
      PRIMARY KEY (`id`),
      KEY `user_id` (`user_id`),
      CONSTRAINT `post_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
    
    create table post_tag(
    
        post_id varchar(40) not null,
        tag varchar(40) not null,
        primary key(post_id,tag),
        foreign key(post_id) references post(id)
    );
