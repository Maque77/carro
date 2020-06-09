package com.java4h.ilcarro.security.dto;

import javax.validation.constraints.Pattern;

import lombok.Getter;

@Getter
public class AuthPair {
	
	@Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\."
	        +"[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
	        +"(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
	             message="{invalid email}")
	private String login;
	
	@Pattern(regexp ="^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=_]).*$", message="{invalid.password}")
	private String password;

}
