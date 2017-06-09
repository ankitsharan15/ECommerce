package com.coviam.blabla.order.dto;

import com.coviam.blabla.order.entity.OrderItem;

public class Product {

	private int productId;
	
	private int merchantId;
	
	private int numOfProducts;
	
	private float rating;
	
	

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(OrderItem orderitem) {
		super();
		this.productId = orderitem.getProductId();
		this.merchantId = orderitem.getMerchantId();
		this.numOfProducts = orderitem.getQuantity();
		this.rating = orderitem.getRating();
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(int merchantId) {
		this.merchantId = merchantId;
	}

	public int getNumOfOrders() {
		return numOfProducts;
	}

	public void setNumOfOrders(int numOfOrders) {
		this.numOfProducts = numOfOrders;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}
	
	
}
