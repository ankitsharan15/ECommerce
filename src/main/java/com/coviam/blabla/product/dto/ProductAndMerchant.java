package com.coviam.blabla.product.dto;

import java.util.List;

import com.coviam.blabla.product.entity.Product;
import com.coviam.blabla.product.entity.ProductMerchant;

public class ProductAndMerchant {

	private List<Product> product;
	private List<ProductMerchant> productmerchant;
	
	public ProductAndMerchant(List<Product> product, List<ProductMerchant> productmerchant) {
		super();
		this.product = product;
		this.productmerchant = productmerchant;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
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
