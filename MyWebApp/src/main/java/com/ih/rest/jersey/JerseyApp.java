package com.ih.rest.jersey;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

@ApplicationPath("/jersey")
public class JerseyApp extends ResourceConfig{

	public JerseyApp(){
		register(RolesAllowedDynamicFeature.class);
	}
	
}
