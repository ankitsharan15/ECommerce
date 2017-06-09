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
	
	@Column(name = "price")
	float price;

	@Column(name = "stock")
	int stock;

	@Column(name = "score")
	double score;

	@Column(name = "capacity")
	int capacity;

	public ProductMerchant(){
		
	}

	public ProductMerchant(ProductMerchantId productmerchantid, float price, int stock, long score, int capacity) {
		super();
		this.productmerchantid = productmerchantid;
		this.price = price;
		this.stock = stock;
		this.score = score;
		this.capacity = capacity;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
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
