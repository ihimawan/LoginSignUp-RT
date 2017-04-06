package com.ih.rest.jersey.securitycontext;

import java.security.Principal;

import javax.ws.rs.core.SecurityContext;

import com.ih.rest.jersey.user.User;

public class MyApplicationSecurityContext implements SecurityContext {
	
	private User user;
	private String scheme;

	//the scheme used, here it will be HTTP Basic Auth.
	public String getAuthenticationScheme() {
		return SecurityContext.BASIC_AUTH;
	}

	//return the user
	public Principal getUserPrincipal() {
		return this.user;
	}

	//making sure user is in HTTPS
	public boolean isSecure() {
		return "https".equals(this.scheme);
	}

	//check if given role is in the role list of the user.
	public boolean isUserInRole(String role) {
		if (user.getRole() != null){
			return user.getRole().contains(role);
		}
		
		return false;
	}

}
