package com.coviam.blabla.product.dto;

import com.coviam.blabla.product.entity.ProductMerchant;

public class ProductMerchantScore {

	private long productId;

	private long stock;

	public ProductMerchantScore() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductMerchantScore(ProductMerchant productmerchant) {
		super();
		this.productId = productmerchant.getProductmerchantid().getProductCode();
		this.stock = productmerchant.getStock();

	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public long getStock() {
		return stock;
	}

	public void setStock(long stock) {
		this.stock = stock;
	}

}