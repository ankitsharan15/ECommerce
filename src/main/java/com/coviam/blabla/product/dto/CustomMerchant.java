package com.coviam.blabla.product.dto;

import java.io.Serializable;

import com.coviam.blabla.product.entity.ProductMerchant;

public class CustomMerchant implements Serializable{

	private ProductMerchant productMerchant;
	private String merchantName;
	public ProductMerchant getProductMerchant() {
		return productMerchant;
	}
	public void setProductMerchant(ProductMerchant productMerchant) {
		this.productMerchant = productMerchant;
	}
	public String getMerchantName() {
		return merchantName;
	}
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	@Override
	public String toString() {
		return "CustomMerchant [productMerchant=" + productMerchant + ", merchantName=" + merchantName + "]";
	}
	public CustomMerchant(ProductMerchant productMerchant, String merchantName) {
		super();
		this.productMerchant = productMerchant;
		this.merchantName = merchantName;
	}
	
	public CustomMerchant(){
		
	}
	
}
