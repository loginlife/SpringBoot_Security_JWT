package com.huangx.springboot.jwt.config;

import com.huangx.springboot.jwt.filter.JwtFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * This is Jwt configuration which set the url "/secure/*" for filtering
 * Created by Administrator on 2018/5/18.
 */
@Configuration
public class JwtConfig {

	@Bean
	public FilterRegistrationBean jwtFilter() {
		final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		// 添加过滤器
		registrationBean.setFilter(new JwtFilter());
		// 设置过滤器过滤的地址
		registrationBean.addUrlPatterns("/secure/*");

		return registrationBean;
	}

}
