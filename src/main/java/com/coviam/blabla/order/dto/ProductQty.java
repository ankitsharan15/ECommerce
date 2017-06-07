package com.coviam.blabla.order.dto;

import com.coviam.blabla.order.entity.OrderItem;

public class ProductQty {

	private long productId;
	
	private long merchantId;
	
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

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public long getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(long merchantId) {
		this.merchantId = merchantId;
	}

	public int getNumOfOrders() {
		return numOfProducts;
	}

	public void setNumOfOrders(int numOfOrders) {
		this.numOfProducts = numOfOrders;
	}

	
	
	
}
