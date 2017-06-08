package com.coviam.blabla.product.dto;

public class ProductMerchantList {

	private int productCode;
	private int merchantId;
	private String productName;
	private String merchantName;
	private String productImage;

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

	public int getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(int merchantId) {
		this.merchantId = merchantId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public ProductMerchantList(int productCode, int merchantId, String productName, String merchantName,
			String productImage) {
		super();
		this.productCode = productCode;
		this.merchantId = merchantId;
		this.productName = productName;
		this.merchantName = merchantName;
		this.productImage = productImage;
	}

	@Override
	public String toString() {
		return "ProductMerchantList [productCode=" + productCode + ", merchantId=" + merchantId + ", productName=" + productName + ", merchantName=" + merchantName + ", productImage=" + productImage
				+ "]";
	}

	public ProductMerchantList() {

	}
}
