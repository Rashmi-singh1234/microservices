package com.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.entity.LoginRequest;
import com.product.entity.LoginResponse;
import com.product.service.JwtUtils;
import com.product.service.MyAppUserDetailsService;

@RestController
@RequestMapping("/login")
public class AuthenticationController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	MyAppUserDetailsService userDetailsService;
	
	@Autowired
	JwtUtils jwtutils;
	
	@PostMapping("/")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) throws Exception{
		try {
    	authenticationManager.authenticate
    	(new UsernamePasswordAuthenticationToken(loginRequest.getUserName(),loginRequest.getPassword()));
		}
		catch(BadCredentialsException e) {
			throw new Exception("Bad credentials..Invalid user");
		}
		
		UserDetails userdetails=userDetailsService.loadUserByUsername(loginRequest.getUserName());
		String jwt=jwtutils.generateToken(userdetails);
		
		return new LoginResponse(jwt);
    }
}
