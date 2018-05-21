package com.huangx.springboot.jwt.config;

import com.huangx.springboot.jwt.service.PersonService;
import com.huangx.springboot.jwt.model.Person;
import com.huangx.springboot.jwt.enums.RoleEnum;
import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/18.
 */
@Configuration
public class IgniteConfig {

	@Autowired
	private PersonService personService;

	/**
	 * 初始化ignite节点信息
	 * @return Ignite
	 */
	@Bean
	public Ignite igniteInstance() {
		// 配置IgniteConfiguration
		IgniteConfiguration cfg = new IgniteConfiguration();

		// 设置节点名称
		cfg.setIgniteInstanceName("springDataNode");

		// 启用Peer类加载器
		cfg.setPeerClassLoadingEnabled(true);

		// 创建一个新的Cache以供Ignite节点使用
		CacheConfiguration ccfg = new CacheConfiguration("PersonCache");

		// 设置SQL的Schema
		ccfg.setIndexedTypes(Long.class, Person.class);
		cfg.setCacheConfiguration(ccfg);
		return Ignition.start(cfg);
	}


	/**
	 * Add few people in ignite for testing easily
	 */
	@Bean
	public int addPerson() {
		// Give a default role : MEMBER
		List<RoleEnum> roles = new ArrayList<>();
		roles.add(RoleEnum.MEMBER);

		// add data
		personService.save(new Person("test1", "test1", roles));
		personService.save(new Person("test2", "test2", roles));
		personService.save(new Person("test3", "test3", roles));
		return 0;
	}

}
