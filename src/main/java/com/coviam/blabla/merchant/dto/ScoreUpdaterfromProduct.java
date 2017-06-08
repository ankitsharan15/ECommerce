package com.coviam.blabla.merchant.dto;


public class ScoreUpdaterfromProduct {
	private int merchantId;
	private int numOfProdOfMerchant;
	private int currentStock;
	float price;
	
	public ScoreUpdaterfromProduct(int merchantId, int numOfProdOfMerchant, int currentStock, float price) {
		super();
		this.merchantId = merchantId;
		this.numOfProdOfMerchant = numOfProdOfMerchant;
		this.currentStock = currentStock;
		this.price = price;
	}
	
	public int getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(int merchantId) {
		this.merchantId = merchantId;
	}
	public int getNumOfProdOfMerchant() {
		return numOfProdOfMerchant;
	}
	public void setNumOfProdOfMerchant(int numOfProdOfMerchant) {
		this.numOfProdOfMerchant = numOfProdOfMerchant;
	}
	public int getCurrentStock() {
		return currentStock;
	}
	public void setCurrentStock(int currentStock) {
		this.currentStock = currentStock;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
}
