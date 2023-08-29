package com.product.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.product.entity.AppUser;
import com.product.repository.UserRepository;


@Service
public class MyAppUserDetailsService implements UserDetailsService{
    
	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser appUser=userRepository.findByUserName(username);
		return new User(appUser.getUserName(),appUser.getPassword(),new ArrayList<>());
	}

}
