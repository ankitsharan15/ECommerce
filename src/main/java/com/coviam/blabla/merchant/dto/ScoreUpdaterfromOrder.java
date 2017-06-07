package com.coviam.blabla.dto;

import com.coviam.blabla.entity.Score;

public class ScoreUpdaterfromOrder {
	private long productId;
	private long merchantId;
	private int numOfProd;
	private double rating;
	
	
	public ScoreUpdaterfromOrder(Score score,int numOfProd,Double rating) {
		super();
		this.productId = score.getScoreId().getProductId();
		this.merchantId = score.getScoreId().getMerchantId();
		this.numOfProd = numOfProd;
		this.rating = rating;
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
