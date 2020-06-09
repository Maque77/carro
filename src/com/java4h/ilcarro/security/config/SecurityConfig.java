package com.java4h.ilcarro.security.config;

import com.java4h.ilcarro.jwt.JWTAuthenticationEntryPoint;
import com.java4h.ilcarro.jwt.JWTFilter;
import com.java4h.ilcarro.security.utils.API;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	JWTAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	@Autowired
	JWTFilter jwtRequestFilter;

	@Override
	protected void configure(HttpSecurity http)throws Exception{

		http.csrf().disable();//allows for spring security 2 running POST requests
		http.httpBasic();//enabling baseAuthentication

		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.cors();

//		http.authorizeRequests().antMatchers("/**").permitAll(); // init backdoor


		// ADMIN only
		http.authorizeRequests().antMatchers(
												API.SECURITY + API.ADD_ACCOUNT,
												API.SECURITY + API.CREATE_ROLE,
												API.SECURITY + API.GRANT_ROLE,
												API.SECURITY + API.DEPRIVE_ROLE,
												API.SECURITY + API.GET_ALL_ACCOUNTS,
												API.SECURITY + API.GET_ACCOUNTS_BY_ROLE,
												API.SECURITY + API.GET_ALL_ROLES,
												API.SECURITY + API.GET_ROLES_BY_LOGIN,
												API.SECURITY + API.REMOVE_ACCOUNT
												/*nado dopisat controllers CARS*/

																
																					).hasRole("ADMIN");
		// ADMIN and USER only
		http.authorizeRequests().antMatchers(
												API.SECURITY + API.REMOVE_USER,
												API.USER + API.GET_USER_BY_LOGIN,
												API.USER + API.UPDATE_USER_BY_LOGIN,
												API.USER + API.GET_CARS_BY_LOGIN,//te, chto sdaet v arendu
												API.USER + API.SELECTED_TO_RENT_BY_LOGIN,//te, chto otobral v korzinu
												API.USER + API.GET_COMMENTS_BY_LOGIN,
												API.USER + API.SEND_MESSAGE_BY_LOGIN,
												
												API.BUSINESS + API.ADD_CAR
																					).hasAnyRole("ADMIN", "USER");

		//everybody
		http.authorizeRequests().antMatchers(
												API.JWT + API.AUTHENTICATE,
												API.SECURITY + API.ADD_USER /*,
												API.BUSINESS + API.GET_ALL_CARS*/
																					).permitAll();

		//close everything else for not authenticated
		http.authorizeRequests().anyRequest().authenticated();

		//add JWT filter
		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}

	@Bean
	public AuthenticationManager customAuthenticationManager() throws Exception {
		return authenticationManager();
	}
}







