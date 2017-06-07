package com.coviam.blabla.order.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(OrderId.class)
@Table(name="ORDERITEMS")
public class OrderItem {
	
	@Id
	@Column(name="ORDERID")
	private long orderId;
	@Id
	@Column(name="PRODUCTID")
	private long productId;
	@Id
	@Column(name="MERCHANTID")
	private long merchantId;
	@Column(name="QUANTITY")
	private int quantity;
	@Column(name="RATING")
	private float rating;
	@Column(name="REVIEWS")
	private String reviews;
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
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
