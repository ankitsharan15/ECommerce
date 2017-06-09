package com.coviam.blabla.order.dto;

import java.io.Serializable;

import com.coviam.blabla.order.entity.OrderItem;

public class ProductQty implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int productId;

	private int merchantId;

	private int numOfProducts;

	public ProductQty() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductQty(OrderItem orderitem) {
		super();
		this.productId = orderitem.getProductId();
		this.merchantId = orderitem.getMerchantId();
		this.numOfProducts = orderitem.getQuantity();

	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public long getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(int merchantId) {
		this.merchantId = merchantId;
	}

	public int getNumOfOrders() {
		return numOfProducts;
	}

	public void setNumOfOrders(int numOfOrders) {
		this.numOfProducts = numOfOrders;
	}

	@Override
	public String toString() {
		return "ProductQty [productId=" + productId + ", merchantId=" + merchantId + ", numOfProducts=" + numOfProducts
				+ "]";
	}

}
