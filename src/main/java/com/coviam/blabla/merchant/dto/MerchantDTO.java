package com.coviam.blabla.merchant.dto;

import com.coviam.blabla.merchant.entity.Merchant;

public class MerchantDTO{

	private double merchantRating;
	private String merchantName;
	private String merchantLogo;
	private String merchantCity;
	private String merchantCountry;
	private int ratingCounter;

	public double getMerchantRating() {
		return merchantRating;
	}
	public MerchantDTO(Merchant merchant) {
		super();
		this.merchantRating = merchant.getMerchantRating();
		this.merchantName = merchant.getMerchantName();
		this.merchantLogo = merchant.getMerchantLogo();
		this.merchantCity = merchant.getMerchantCity();
		this.merchantCountry = merchant.getMerchantCountry();
		this.ratingCounter = merchant.getRatingCounter();
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
	public String getMerchantLogo() {
		return merchantLogo;
	}
	public void setMerchantLogo(String merchantLogo) {
		this.merchantLogo = merchantLogo;
	}
	public String getMerchantCity() {
		return merchantCity;
	}
	public void setMerchantCity(String merchantCity) {
		this.merchantCity = merchantCity;
	}
	public String getMerchantCountry() {
		return merchantCountry;
	}
	public void setMerchantCountry(String merchantCountry) {
		this.merchantCountry = merchantCountry;
	}
	public int getRatingCounter() {
		return ratingCounter;
	}
	public void setRatingCounter(int ratingCounter) {
		this.ratingCounter = ratingCounter;
	}
	@Override
	public String toString() {
		return "ListofMerchants [merchantRating=" + merchantRating + ", merchantName=" + merchantName
				+ ", merchantLogo=" + merchantLogo + ", merchantCity=" + merchantCity + ", merchantCountry="
				+ merchantCountry + ", ratingCounter=" + ratingCounter + "]";
	}
}
