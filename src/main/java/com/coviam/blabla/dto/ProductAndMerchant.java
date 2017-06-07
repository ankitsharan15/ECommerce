package com.coviam.blabla.dto;

import java.util.List;

import com.coviam.blabla.entity.Product;
import com.coviam.blabla.entity.ProductMerchant;

public class ProductAndMerchant {

	private Product product;
	private List<ProductMerchant> productmerchant;
	
	public ProductAndMerchant(Product product, List<ProductMerchant> productmerchant) {
		super();
		this.product = product;
		this.productmerchant = productmerchant;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<ProductMerchant> getProductmerchant() {
		return productmerchant;
	}

	public void setProductmerchant(List<ProductMerchant> productmerchant) {
		this.productmerchant = productmerchant;
	}

	@Override
	public String toString() {
		return "ProductAndMerchant [product=" + product + ", productmerchant=" + productmerchant + "]";
	}
	
	
	
}
