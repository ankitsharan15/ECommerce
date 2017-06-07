package com.coviam.blabla.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProductMerchantId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "product_code")
	int productCode;

	@Column(name = "merchant_id")
	int merchantId;

	public ProductMerchantId(){
		
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

	public ProductMerchantId(int productCode, int merchantId) {
		this.productCode = productCode;
		this.merchantId = merchantId;
	}

}
