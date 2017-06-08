package com.coviam.blabla.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="merchant")
public class Merchant implements Serializable{
	@Id
	@Column(name="merchant_id")
	private int merchantId;
	@Column(name="merchant_rating")
	double merchantRating;
	@Column(name="merchant_name")
	String merchantName;
	@Column(name="merchant_logo")
	String merchantLogo;
	@Column(name="merchant_city")
	String merchantCity;
	@Column(name="merchant_country")
	String merchantCountry;
	@Column(name="rating_counter")
	int ratingCounter;
	public int getRatingCounter() {
		return ratingCounter;
	}

	public Merchant(){
		
	}
	
	public Merchant(int merchantId, double merchantRating, String merchantName, String merchantLogo,
			String merchantCity, String merchantCountry, int ratingCounter) {
		super();
		this.merchantId = merchantId;
		this.merchantRating = merchantRating;
		this.merchantName = merchantName;
		this.merchantLogo = merchantLogo;
		this.merchantCity = merchantCity;
		this.merchantCountry = merchantCountry;
		this.ratingCounter = ratingCounter;
	}

	@Override
	public String toString() {
		return "Merchant [merchantId=" + merchantId + ", merchantRating=" + merchantRating + ", merchantName="
				+ merchantName + ", merchantLogo=" + merchantLogo + ", merchantCity=" + merchantCity
				+ ", merchantCountry=" + merchantCountry + ", ratingCounter=" + ratingCounter + "]";
	}

	public void setRatingCounter(int ratingCounter) {
		this.ratingCounter = ratingCounter;
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
	

}
