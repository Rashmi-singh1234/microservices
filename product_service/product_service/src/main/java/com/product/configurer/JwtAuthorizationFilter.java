package com.product.configurer;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.product.service.JwtUtils;
import com.product.service.MyAppUserDetailsService;

@Component
public class JwtAuthorizationFilter extends OncePerRequestFilter{
    
	@Autowired
	private JwtUtils jwtUtil;
	
	@Autowired
	private MyAppUserDetailsService myappuserdetailsservice;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		//get jwt
		//start with bearer
		//validate
		
		String requestTokenHeader=request.getHeader("Authorization");
		String userName=null;
		String jwtToken=null;
		
		if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer "))
		{
			jwtToken=requestTokenHeader.substring(7);
			
			try {
				
				userName=this.jwtUtil.extractUsername(jwtToken);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		    UserDetails userDetails=this.myappuserdetailsservice.loadUserByUsername(userName);
			
			if(userName!=null && SecurityContextHolder.getContext().getAuthentication()==null)
			{
				
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken	=new UsernamePasswordAuthenticationToken(userDetails, null,userDetails.getAuthorities());
			
			usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			
			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
			
			else {
				
				System.out.println("token is not validated");
			}
			
	   }
		filterChain.doFilter(request,response);
	}
}
