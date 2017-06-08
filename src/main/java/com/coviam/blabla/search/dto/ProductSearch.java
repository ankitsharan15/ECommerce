package com.coviam.blabla.search.dto;

public class ProductSearch {

	private int productCode;
	private String productName;
	private String productImage;
	private float price;

	public ProductSearch(int productCode, String productName, String productImage, float price) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.productImage = productImage;
		this.price = price;
	}
	
	public int getProductCode() {
		return productCode;
	}

	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductSearch [productCode=" + productCode + ", productName=" + productName + ", productImage="
				+ productImage + ", price=" + price + "]";
	}

}
