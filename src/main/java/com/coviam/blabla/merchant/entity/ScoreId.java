package com.coviam.blabla.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class ScoreId implements Serializable{
	@Column(name="merchant_id")
	long merchantId;
	@Column(name="product_id")
	long productId;
	public ScoreId() {
		super();
		}
	public long getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(long merchantId) {
		this.merchantId = merchantId;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
}