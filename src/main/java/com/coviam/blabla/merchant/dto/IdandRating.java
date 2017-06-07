package com.coviam.blabla.merchant.dto;

import com.coviam.blabla.merchant.entity.Merchant;

public class IdandRating {
	private long merchantId;
	private double merchantRating;
	private String merchantName;
	
	public IdandRating(Merchant merchant) {
		super();
		this.merchantId = merchant.getMerchantId();
		this.merchantRating = merchant.getMerchantRating();
		this.merchantName=merchant.getMerchantName();
	}
	public long getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(long merchantId) {
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