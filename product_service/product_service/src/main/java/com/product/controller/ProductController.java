package com.product.controller;
import java.lang.reflect.Array;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.product.entity.Price;
import com.product.entity.Product;
import com.product.service.ProductService;



@RestController
@RequestMapping("/v1")
public class ProductController {
	
	private Logger logger=LoggerFactory.getLogger(ProductController.class);
    
	@Autowired
	private ProductService productservice;

	
	@PostMapping("/addProduct")
	ResponseEntity<Product> addProduct(@RequestBody Product product){
		
		String status=productservice.addProduct(product);
		logger.info("Product added status - {}",status);
		return ResponseEntity.status(HttpStatus.CREATED).body(product);
	}
	
	@GetMapping("/productList")
	List<Product> productList(){
		return productservice.listAllProducts();
	}
	
	@GetMapping("/productList/{category}")
	List<Product> productCategoryList(@PathVariable String category){
		return productservice.productCategoryList(category);
	}
	
	@GetMapping("/product/{id}")
	Product productById(@PathVariable Integer id){
		return productservice.productById(id);
	}
	
	@PutMapping("/productUpdate")
	String updateProduct(@RequestBody Product product) {
		return productservice.updateProduct(product);
	}
	
	@DeleteMapping("/productList/{id}")
	String deleteProductById(@PathVariable Integer id){
		return productservice.deleteproductById(id);
	}
}
