package com.coviam.blabla.product.dto;

import com.coviam.blabla.product.entity.ProductMerchant;

public class ProductMerchantScore {

private long productId;
	
	private long merchantId;
	
	private long stock;
	
	public ProductMerchantScore() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductMerchantScore(ProductMerchant productmerchant) {
		super();
		this.productId = productmerchant.getProductmerchantid().getProductCode();
		this.merchantId = productmerchant.getProductmerchantid().getMerchantId();
		this.stock = productmerchant.getStock();
		
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

	public long getNumOfOrders() {
		return stock;
	}

	public void setNumOfOrders(long stock) {
		this.stock = stock;
	}

}