package com.huangx.springboot.jwt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by Administrator on 2018/5/18.
 */
@Controller
public class IndexController {
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

	private String getBasePath(HttpServletRequest request) {
		String basePath = request.getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort() + request.getContextPath();
		return basePath;
	}

	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String index(HttpServletRequest request, Map<String,Object> result) {
		logger.info("#### index()");
		result.put("basePath", getBasePath(request));
		return "index";
	}

	@RequestMapping(value = "/uiRegister")
	public String register(HttpServletRequest request, Map<String,Object> result) {
		result.put("basePath", getBasePath(request));
		return "register";
	}

	@RequestMapping(value = "/uiLogin")
	public String login(HttpServletRequest request, Map<String,Object> result) {
		result.put("basePath", getBasePath(request));
		return "login";
	}

	@RequestMapping(value = "uiList")
	public String list(HttpServletRequest request, Map<String,Object> result) {
		result.put("basePath", getBasePath(request));
		return "list";
	}

}
