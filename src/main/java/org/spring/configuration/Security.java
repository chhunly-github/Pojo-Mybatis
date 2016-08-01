package org.spring.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class Security extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication()
		.withUser("admin").password("admin").roles("ADMIN");
		auth.inMemoryAuthentication()
		.withUser("user").password("user").roles("USER");
		auth.inMemoryAuthentication()
		.withUser("dba").password("dba").roles("DBA");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable();
		http.formLogin()
			.loginPage("/login")
			.usernameParameter("username")	//default
			.passwordParameter("password")	//default
			.permitAll();
		http.authorizeRequests()
			.antMatchers("/admin/**").hasRole("ADMIN")
			.and()
			.authorizeRequests()
			.antMatchers("/dba/**").hasAnyRole("DBA","ADMIN")
			.and()
			.authorizeRequests()
			.antMatchers("/user/**").hasAnyRole("ADMIN","DBA","USER");
		http.formLogin();
		
		http.exceptionHandling().accessDeniedPage("/accessDenied");
	}
}
