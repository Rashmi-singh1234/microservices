package com.product.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.product.entity.Price;
import com.product.entity.Product;


@Service
public class ProductService {
    
	List<Product> products=new ArrayList<>();
    
	@Autowired
    RestTemplate resttemplate;
	
	public String addProduct(Product product) {
		double price=this.resttemplate.getForObject("http://localhost:8081/price/product/"+product.getId(),double.class);
		product.setPrice(price);
		products.add(product);
		return "success";
	}

	public List<Product> listAllProducts() {
		return products;
		
	}

	public List<Product> productCategoryList(String category) {
		return products.stream().filter(product->product.getCategory().getName().equalsIgnoreCase(category)).collect(Collectors.toList());
		
	}

	public Product productById(Integer id) {
		return products.stream().filter(product->product.getId().equals(id)).findAny().orElse(null);
	}

	public String updateProduct(Product product) {
		for(Product prod: products) {
			if(prod.getId().equals(product.getId())) {
				prod.setName(product.getName());
				prod.setCategory(product.getCategory());
				prod.setDiscount(product.getDiscount());
				prod.setDiscountDescription(product.getDiscountDescription());
				
				return "product updated successfully!!";
			}
		}
		return "product updation failed!!";
	}

	public String deleteproductById(Integer id) {
		for(Product prod: products) {
			if(prod.getId().equals(id)) {
				products.remove(prod);
				return "Product deleted Successfully";
			}
		}
		return "Product deletion failed!!";
	}

}
