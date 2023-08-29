package com.price.service;

import java.util.List;

import com.price.entity.Price;

public interface PriceService {

	double getPriceOfProduct(Integer productId);

	List<Price> getAllProductPrice();
    
    
}
