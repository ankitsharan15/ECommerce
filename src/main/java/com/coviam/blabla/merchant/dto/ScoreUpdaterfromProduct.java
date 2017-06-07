package com.coviam.blabla.merchant.dto;

import java.util.List;

public class ScoreUpdaterfromProduct {
	private long merchantId;
	private int numOfProdOfMerchant;
	private int currentStock;
	List<Double> priceList;
	
	public ScoreUpdaterfromProduct(long merchantId, int numOfProdOfMerchant, int currentStock, List<Double> priceList) {
		super();
		this.merchantId = merchantId;
		this.numOfProdOfMerchant = numOfProdOfMerchant;
		this.currentStock = currentStock;
		this.priceList = priceList;
	}
	
	public long getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(long merchantId) {
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
	public List<Double> getPriceList() {
		return priceList;
	}
	public void setPriceList(List<Double> priceList) {
		this.priceList = priceList;
	}
	
	
	
}
