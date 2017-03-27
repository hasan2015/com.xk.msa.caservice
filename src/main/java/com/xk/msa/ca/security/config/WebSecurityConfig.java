package com.xk.msa.ca.security.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * 
 * @author yanhaixun
 * @date 2017年3月18日 下午12:23:30
 *
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends AbstractWebSecurityConfig {

	@Value("${com.xk.msa.security.jwt.tokenHeader}")
    private String JWT_TOKEN_HEADER_PARAM;
	@Value("${com.xk.msa.security.jwt.tokenBasedAuthEntryPoint}")
    private String TOKEN_BASED_AUTH_ENTRY_POINT;
	@Value("${com.xk.msa.security.jwt.tokenFormBasedLoginEntryPoint}")
    private String FORM_BASED_LOGIN_ENTRY_POINT;
	@Value("${com.xk.msa.security.jwt.tokenRefreshAuthEntryPoint}")
    private String TOKEN_REFRESH_ENTRY_POINT;
	
	@Override
	protected void setupAuthorization(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				// allow anonymous access to /authenticate endpoint
				.antMatchers("/authenticate").permitAll()
				.and()
	            .authorizeRequests()
//	                .antMatchers(FORM_BASED_LOGIN_ENTRY_POINT).permitAll() // Login end-point
	                .antMatchers(TOKEN_REFRESH_ENTRY_POINT).permitAll() // Token refresh end-point
	                .antMatchers("/console").permitAll() // H2 Console Dash-board - only for testing
	        .and()
	            .formLogin()
	                .loginPage(FORM_BASED_LOGIN_ENTRY_POINT)
	                .permitAll()
	        .and()
	            .logout()
	                .permitAll()                
	        .and()
	            .authorizeRequests()
	                .antMatchers(TOKEN_BASED_AUTH_ENTRY_POINT).authenticated()
//	                .antMatchers("/", "/home").permitAll()
//	                .anyRequest().authenticated()
				// allow anonymous to common static resources
//				.antMatchers(HttpMethod.GET, "/", "/*.html", "/favicon.ico", "/**/*.html", "/**/*.css", "/**/*.js")
				 
		; // 2;
	}
}
