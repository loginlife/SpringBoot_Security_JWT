package com.huangx.springboot.jwt.controller;

import com.huangx.springboot.jwt.service.PersonService;
import com.huangx.springboot.jwt.model.Person;
import com.huangx.springboot.jwt.model.ReturnDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Test the jwt, if the token is valid then return "Login Successful"
 * If is not valid, the request will be intercepted by JwtFilter
 *
 * Created by Administrator on 2018/5/18.
 **/
@RestController
@RequestMapping("/secure") // /secure前缀的请求地址需要JWT进行验证
public class SecureController {
	private static final Logger logger = LoggerFactory.getLogger(SecureController.class);

	@Autowired
	private PersonService personService;


	@RequestMapping("/user/list")
	public ReturnDto<List<Person>> personList() {
		ReturnDto<List<Person>> returnDto = new ReturnDto<>();

		try {
			List<Person> personList = personService.findAll();
			returnDto.setSuccess(personList);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			returnDto.setError("", e.getMessage());
		}

		return returnDto;
	}


}