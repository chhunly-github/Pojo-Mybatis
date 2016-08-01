package org.spring.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class webSecurityConfig extends WebMvcConfigurerAdapter{
	
	
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry){
		
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/admin/index").setViewName("admin/index");
		registry.addViewController("/user/index").setViewName("user/index");
		registry.addViewController("/dba/index").setViewName("dba/index");

		registry.addViewController("/accessDenied").setViewName("error/403");
		registry.addViewController("/login").setViewName("login");
	}
}
