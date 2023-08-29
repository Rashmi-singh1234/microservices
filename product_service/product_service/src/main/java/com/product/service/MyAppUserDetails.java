package com.product.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.product.entity.AppUser;

import org.springframework.security.core.*;

public class MyAppUserDetails implements UserDetails{
	private String userName;
	private String password;
	private boolean active;
	private List<GrantedAuthority> roles;
	

	public MyAppUserDetails(AppUser user) {
		super();
		this.userName = user.getUserName();
		this.password = user.getPassword();
		this.active = user.isActive();
		this.roles=user.getRoles().stream()
		        .map(role -> new SimpleGrantedAuthority(role.getRole_name()))
		        .collect(Collectors.toList());
		
	}


	/*private List<GrantedAuthority> convertAuthorities(List<Role> roles2) {

	        for (Role userRole : roles2) {
	            roles.add(new SimpleGrantedAuthority(userRole.getRole_name()));
	        }
	        return roles;
	    }
*/
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return active;
	}
    
}
