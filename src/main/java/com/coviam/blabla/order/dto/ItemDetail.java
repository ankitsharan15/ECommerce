package com.coviam.blabla.order.dto;

import com.coviam.blabla.order.entity.OrderItem;

public class ItemDetail {

	private long productId;
	private long merchantId;
	private int quantity;
	private float rating;
	private String reviews;

	public ItemDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ItemDetail(OrderItem orderItem) {
		super();
		this.productId = orderItem.getProductId();
		this.merchantId = orderItem.getMerchantId();
		this.quantity = orderItem.getQuantity();
		this.rating = orderItem.getRating();
		this.reviews = orderItem.getReviews();
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public long getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(long merchantId) {
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

}
