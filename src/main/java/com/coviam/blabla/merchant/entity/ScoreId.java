package com.coviam.blabla.merchant.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class ScoreId implements Serializable{
	@Column(name="merchant_id")
	int merchantId;
	@Column(name="product_id")
	int productId;
	public ScoreId() {
		super();
		}
	public int getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(int merchantId) {
		this.merchantId = merchantId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
}