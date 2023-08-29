package com.product.entity;

import java.util.List;

public class Product {
	
	private Integer id;
	private String name;
	private Category category;
	private double price;
	private double discount;
	private String discountDescription;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price2) {
		this.price = price2;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public String getDiscountDescription() {
		return discountDescription;
	}
	public void setDiscountDescription(String discountDescription) {
		this.discountDescription = discountDescription;
	}
	/*
	{
        "id": 127,
        "name": "Redmi9",
        "category": {
            "id": 721,
            "name": "phone",
            "brand": "MI"
        },
        "discount": 2900.0,
        "discountDescription": "Year end sale offer"
    }
    */
}
