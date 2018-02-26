package com.open.micro.service.config.interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
public class InteceptorAdder extends WebMvcConfigurerAdapter{
	
	@Autowired private LoggerInteceptor loggerInteceptor;
	@Autowired private LocaleChangeInterceptor localeChangeInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		super.addInterceptors(registry);
		/*
		 /**表示拦截/下的所有路径， /*表示只拦截/下的一级路径  
		 */
		registry.addInterceptor( loggerInteceptor ).addPathPatterns("/**");
		registry.addInterceptor( localeChangeInterceptor );
	}
}