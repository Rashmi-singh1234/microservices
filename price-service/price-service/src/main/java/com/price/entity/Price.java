package com.price.entity;

public class Price {
	
	private Long priceId;
	private Integer productId;
	private double price;
	
	public Price() {
		super();
	}
	
	public Price(Long priceId, Integer productId, double price) {
		super();
		this.priceId = priceId;
		this.productId = productId;
		this.price = price;
	}
	
	public Long getPriceId() {
		return priceId;
	}
	public void setPriceId(Long priceId) {
		this.priceId = priceId;
	}
	
	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
