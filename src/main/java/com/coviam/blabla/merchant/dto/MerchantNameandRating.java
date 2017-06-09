package com.coviam.blabla.dto;

import com.coviam.blabla.entity.Merchant;

public class MerchantNameandRating{
	private int merchantId;
	private double merchantRating;
	private String merchantName;
	
	public MerchantNameandRating() {
	}
	public MerchantNameandRating(Merchant merchant) {
		super();
		this.merchantId = merchant.getMerchantId();
		this.merchantRating = merchant.getMerchantRating();
		this.merchantName=merchant.getMerchantName();
	}
	public int getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(int merchantId) {
		this.merchantId = merchantId;
	}
	public double getMerchantRating() {
		return merchantRating;
	}
	public void setMerchantRating(double merchantRating) {
		this.merchantRating = merchantRating;
	}
	public String getMerchantName() {
		return merchantName;
	}
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
}