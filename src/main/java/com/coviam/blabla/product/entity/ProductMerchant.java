package com.coviam.blabla.product.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_merchant")
public class ProductMerchant implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Embedded
	private ProductMerchantId productmerchantid;
	
//	@Column(name = "product_code")
//	int productCode;
//
//	@Column(name = "merchant_id")
//	int merchantId;

	@Column(name = "price")
	float price;

	@Column(name = "stock")
	long stock;

	@Column(name = "score")
	long score;

	@Column(name = "capacity")
	long capacity;
	

	public long getCapacity() {
		return capacity;
	}

	public void setCapacity(long capacity) {
		this.capacity = capacity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public long getStock() {
		return stock;
	}

	public void setStock(long stock) {
		this.stock = stock;
	}

	public long getScore() {
		return score;
	}

	public void setScore(long score) {
		this.score = score;
	}

	public ProductMerchantId getProductmerchantid() {
		return productmerchantid;
	}

	public void setProductmerchantid(ProductMerchantId productmerchantid) {
		this.productmerchantid = productmerchantid;
	}

	@Override
	public String toString() {
		return "ProductMerchant [productmerchantid=" + productmerchantid + ", price=" + price + ", stock=" + stock
				+ ", score=" + score + ", capacity=" + capacity + "]";
	}

	

	

}
