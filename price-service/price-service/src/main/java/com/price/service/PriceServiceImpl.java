package com.price.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.price.entity.Price;


@Service
public class PriceServiceImpl implements PriceService{

 
	List<Price> list=List.of(
			new Price(1L,125,50000.00),
			new Price(2L,126,25000.00),
			new Price(3L,127,12000.00),
			new Price(4L,128,6000.00),
			new Price(5L,129,3000.00),
			new Price(6L,130,1500.00)
			);

	@Override
	public double getPriceOfProduct(Integer productId){
	    List<Price> price1=list.stream().filter(Price->Price.getProductId().equals(productId)).collect(Collectors.toList());
	    Price price2= price1.get(0);
	    return price2.getPrice();
	}

	@Override
	public List<Price> getAllProductPrice() {
		return list;
	}

}
