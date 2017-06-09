package com.coviam.blabla.merchant.dto;

public class ScoreUpdaterfromOrder {
	private int productId;
	private int merchantId;
	private int numOfProd;
	private double rating;
	
	public ScoreUpdaterfromOrder() {
	}
	
	public ScoreUpdaterfromOrder(int productId, int merchantId, int numOfProd, double rating) {
		super();
		this.productId = productId;
		this.merchantId = merchantId;
		this.numOfProd = numOfProd;
		this.rating = rating;
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
	public int getNumOfProd() {
		return numOfProd;
	}
	public void setNumOfProd(int numOfProd) {
		this.numOfProd = numOfProd;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "ScoreUpdaterfromOrder [productId=" + productId + ", merchantId=" + merchantId + ", numOfProd="
				+ numOfProd + ", rating=" + rating + "]";
	}
	
	
}
