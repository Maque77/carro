package com.java4h.ilcarro.jwt;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class JWTAuthenticationEntryPoint implements AuthenticationEntryPoint{

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
						AuthenticationException authException) throws IOException {
		String msg = (String) request.getAttribute("wrongToken");
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized"+ msg == null ? "" : " "+msg);
	}
}
