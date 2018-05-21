package com.huangx.springboot.jwt;

import org.apache.ignite.springdata.repository.config.EnableIgniteRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 该项目是用于将 Ignite 部署到 SpringBoot 上的一个测试性的项目
 *
 * 目前的功能包含：
 * 1. 启动并使用一个ignite节点
 * 2. 提供api接口实现 RESTful 的设计，能够通过api添加与查询Cache中的相关内容
 *
 * It's a test project for deploying Ignite on SpringBoot
 *
 * Function:
 * 1. Start an ignite node
 * 2. provide RESTful api to create or retrieve information in Ignite Cache
 *
 * Here are the apis:
 * /person?name=XXX&phone=XXX  get, store the person in Ignite and return a json of the person
 * /persons?name=xxx           get, return a json of the person
 *
 * 项目启动入口，配置 @EnableIgniteRepositories 注解以支持ignite的 @RepositoryConfig
 *
 * Created by Administrator on 2018/5/18.
 */
@EnableAutoConfiguration
@SpringBootApplication
@EnableIgniteRepositories
public class UsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersApplication.class, args);
	}

}