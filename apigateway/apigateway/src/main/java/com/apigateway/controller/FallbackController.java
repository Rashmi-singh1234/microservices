package com.apigateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {
   
	
	@GetMapping("/userServiceFallback")
	public String userServiceFallback() {
		return "User service is down this time!!";
	}
	
	@GetMapping("/contactServiceFallback")
	public String contactServiceFallback() {
		return "Contact service is down this time!!";
	}
	
	@GetMapping("/priceServiceFallback")
	public String priceServiceFallback() {
		return "Price service is down this time!!";
	}
	
	@GetMapping("/productServiceFallback")
	public String productServiceFallback() {
		return "Product service is down this time!!";
	}
}
