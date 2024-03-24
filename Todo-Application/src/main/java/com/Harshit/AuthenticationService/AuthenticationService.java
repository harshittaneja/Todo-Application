package com.Harshit.AuthenticationService;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	
	public boolean authenticate(String username, String password) {
		
		boolean isValidUserName = username.equalsIgnoreCase("Harshit");
		boolean isValidPassword = password.equalsIgnoreCase("Harshit@123");
		
		return isValidUserName && isValidPassword;
	}
}