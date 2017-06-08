package com.coviam.blabla.merchant.dto;

import com.coviam.blabla.merchant.entity.Score;

public class ScoreUpdaterfromOrder {
	private int productId;
	private int merchantId;
	private int numOfProd;
	private double rating;
	
	
	public ScoreUpdaterfromOrder(Score score,int numOfProd,Double rating) {
		super();
		this.productId = score.getScoreId().getProductId();
		this.merchantId = score.getScoreId().getMerchantId();
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
	
	
}
