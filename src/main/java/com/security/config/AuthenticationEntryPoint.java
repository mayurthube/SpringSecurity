package com.security.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationEntryPoint  {
	/*@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException {
		response.addHeader("WWW.Authenticat", "Basic relam"+getRealmName());
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		PrintWriter writer = response.getWriter();
		writer.print("HTTP status 401" +authException.getMessage());
	}
	
	@Override
	public void afterPropertiesSet() {
		setRealmName("MightyJava");
		super.afterPropertiesSet();
	}*/
}
