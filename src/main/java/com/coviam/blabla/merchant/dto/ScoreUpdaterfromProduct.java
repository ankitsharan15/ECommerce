package com.coviam.blabla.dto;

public class ScoreUpdaterfromProduct {
	private int merchantId;
	private int numOfProdOfMerchant;
	private int currentStock;
	double price;
	
	
	public ScoreUpdaterfromProduct() {
	}

//	public ScoreUpdaterfromProduct(int merchantId, int numOfProdOfMerchant, int currentStock, double price) {
//		super();
//		this.merchantId = merchantId;
//		this.numOfProdOfMerchant = numOfProdOfMerchant;
//		this.currentStock = currentStock;
//		this.price = price;
//	}
//	
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	
}
