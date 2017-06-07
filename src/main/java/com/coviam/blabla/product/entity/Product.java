package com.coviam.blabla.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Product")
public class Product {

	@Id
	@Column(name = "product_code")
	private int productCode;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "product_usp")
	private String productUsp;

	@Column(name = "product_category")
	private String productCategory;

	@Column(name = "product_desc")
	private String productDesc;

	@Column(name = "product_brand")
	private String productBrand;

	@Column(name = "product_image")
	private String productImage;

	@Column(name = "best_price")
	private float bestPrice;

	public Product(int productCode, String productName, String productUsp, String productCategory, String productDesc,
			String productBrand, String productImage, float bestPrice) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.productUsp = productUsp;
		this.productCategory = productCategory;
		this.productDesc = productDesc;
		this.productBrand = productBrand;
		this.productImage = productImage;
		this.bestPrice = bestPrice;
	}

	public float getBestPrice() {
		return bestPrice;
	}

	public void setBestPrice(float bestPrice) {
		this.bestPrice = bestPrice;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
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

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public String getProductBrand() {
		return productBrand;
	}

	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}

	@Override
	public String toString() {
		return "Product [productCode=" + productCode + ", productName=" + productName + ", productUsp=" + productUsp
				+ ", productCategory=" + productCategory + ", productDesc=" + productDesc + ", productBrand="
				+ productBrand + ", productImage=" + productImage + ", bestPrice=" + bestPrice + "]";
	}

}
