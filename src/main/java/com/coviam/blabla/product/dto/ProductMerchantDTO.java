package com.coviam.blabla.product.dto;

public class ProductMerchantDTO {

	private int productCode;
	private int merchantId;

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

	@Override
	public String toString() {
		return "ProductMerchantDTO [productCode=" + productCode + ", merchantId=" + merchantId + "]";
	}

	public ProductMerchantDTO(){
		
	}
	
	public ProductMerchantDTO(int productCode, int merchantId) {
		super();
		this.productCode = productCode;
		this.merchantId = merchantId;
	}

}