package com.coviam.blabla.product.entity;

public class ProductPrice {

	private int productCode;
	private String productName;
	private String productUsp;
	private String productDesc;
	private String productImage;
	private String productCategory;
	private String productBrand;
	private float productPrice;
	
	public ProductPrice(){
		
	}
	
	public ProductPrice(Product product, float productPrice) {
		super();
		this.productCode = product.getProductCode();
		this.productName = product.getProductName();
		this.productUsp = product.getProductUsp();
		this.productDesc = product.getProductDesc();
		this.productImage = product.getProductImage();
		this.productCategory = product.getProductCategory();
		this.productBrand = product.getProductBrand();
		this.productPrice = productPrice;
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
	public String getProductUsp() {
		return productUsp;
	}
	public void setProductUsp(String productUsp) {
		this.productUsp = productUsp;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public String getProductBrand() {
		return productBrand;
	}
	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}
	public float getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}
	@Override
	public String toString() {
		return "ProductPrice [productCode=" + productCode + ", productName=" + productName + ", productUsp="
				+ productUsp + ", productDesc=" + productDesc + ", productImage=" + productImage + ", productCategory="
				+ productCategory + ", productBrand=" + productBrand + ", productPrice=" + productPrice + "]";
	}
	
	
	
}
