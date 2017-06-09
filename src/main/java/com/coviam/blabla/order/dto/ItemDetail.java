package com.coviam.blabla.order.dto;

import java.io.Serializable;

import com.coviam.blabla.order.entity.OrderItem;

public class ItemDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int productId;
	private String productName;
	private int merchantId;
	private String merchantName;
	private int quantity;
	private float price;
	private float rating;
	private String reviews;
	private String imageUrl;

	public ItemDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ItemDetail(OrderItem orderItem) {
		super();
		this.productId = orderItem.getProductId();
		this.merchantId = orderItem.getMerchantId();
		this.quantity = orderItem.getQuantity();
		this.price = orderItem.getPrice();
		this.rating = orderItem.getRating();
		this.reviews = orderItem.getReviews();
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public String getReviews() {
		return reviews;
	}

	public void setReviews(String reviews) {
		this.reviews = reviews;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	

}
