package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.inMemoryAuthentication().withUser("aa").password("aa")// 在内存中设置用户名和密码
				.roles("USER");//级别设置为user
		
		auth.inMemoryAuthentication().withUser("bb").password("bb")// 在内存中设置用户名和密码
		.roles("ADMIN");//级别设置为admin
	}
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated()// 所有的url都需要认证
			.and().formLogin()
			.loginPage("/login") //设置登录页面
			.permitAll()
			.and().httpBasic()
			.and()
			.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"));// logout
//			.and().csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()); 
//			.logoutUrl("/login")
//			.logoutSuccessUrl("/login");
		http.csrf().disable();
	}
}
