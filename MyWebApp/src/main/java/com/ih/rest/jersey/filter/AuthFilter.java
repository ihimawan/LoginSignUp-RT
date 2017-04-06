package com.ih.rest.jersey.filter;

import java.io.IOException;

import javax.annotation.Priority;
import javax.ws.rs.ForbiddenException;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

import com.ih.rest.jersey.securitycontext.MyApplicationSecurityContext;
import com.ih.rest.jersey.user.User;

@Provider
@PreMatching
@Priority(Priorities.AUTHENTICATION)
public class AuthFilter implements ContainerRequestFilter {
	
	private final String AUTHENTICATION_KEY = "Authorization";

	public void filter(ContainerRequestContext containerRequest) throws IOException {

		System.out.println("FILTER IS EXECUTED!!!");
		
		String path = containerRequest.getUriInfo().getPath();
		System.out.println(path);
		
		String auth = containerRequest.getHeaders().getFirst(AUTHENTICATION_KEY);
		
		ErrorMessage error = new ErrorMessage();
		error.setErrorCode("403");
		error.setMessage("you do not have authorization. Sorry.");
		
		
		if (auth == null){
			throw new ForbiddenException(Response.status(Status.FORBIDDEN).entity(error).build());
		}
		
		String[] userpass = BasicAuth.decode(auth);
		
		System.out.println(userpass[0] + " " + userpass[1]);
		
		if (userpass != null && 
				"user".equals(userpass[0]) && 
				"pass".equals(userpass[1])){
			
			User user = new User();
			user.getRole().add("admin");
			System.out.println("ok you are admin.");
			
			String scheme = containerRequest.getUriInfo().getRequestUri().getScheme();
			containerRequest.setSecurityContext(new MyApplicationSecurityContext(user, scheme));
			
		}else{
			throw new ForbiddenException(Response.status(Status.FORBIDDEN).entity(error).build());
		}
		
		
		
	}

}
