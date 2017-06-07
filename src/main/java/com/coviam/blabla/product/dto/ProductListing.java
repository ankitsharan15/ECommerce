package com.coviam.blabla.product.dto;

import java.util.List;

import com.coviam.blabla.product.entity.Product;
import com.coviam.blabla.product.entity.ProductMerchant;

public class ProductListing {

	private List<Product> productList;
	private List<List<ProductMerchant>> productMerchantList;

	public ProductListing(List<Product> productList, List<List<ProductMerchant>> productMerchantList) {
		super();
		this.productList = productList;
		this.productMerchantList = productMerchantList;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public List<List<ProductMerchant>> getProductMerchantList() {
		return productMerchantList;
	}

	public void setProductMerchantList(List<List<ProductMerchant>> productMerchantList) {
		this.productMerchantList = productMerchantList;
	}

	@Override
	public String toString() {
		return "ProductListing [productList=" + productList + ", productMerchantList=" + productMerchantList + "]";
	}

}
