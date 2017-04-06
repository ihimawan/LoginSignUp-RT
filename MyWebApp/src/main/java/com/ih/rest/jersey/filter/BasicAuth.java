package com.ih.rest.jersey.filter;

import com.sun.jersey.core.util.Base64;

public class BasicAuth {

	public static String[] decode(String auth){
		auth = auth.replaceFirst("[B|b]asic ", "");
		
		auth = Base64.base64Decode(auth);
		
		if (auth == null | auth.length() == 0){
			return null;
		}
		
		return auth.split(":");
	}
	
}
