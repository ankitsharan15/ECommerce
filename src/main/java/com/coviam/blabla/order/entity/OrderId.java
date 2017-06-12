package com.coviam.blabla.order.entity;

import java.io.Serializable;

public class OrderId implements Serializable {
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long orderId;
	private int productId;
	private int merchantId;
	
	public OrderId(){
		
	}
	
	public OrderId(long orderId, int productId, int merchantId) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.merchantId = merchantId;
	}

	public long getOrderId() {
		return orderId;
	}

	public int getProductId() {
		return productId;
	}

	public int getMerchantId() {
		return merchantId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (merchantId ^ (merchantId >>> 32));
		result = prime * result + (int) (orderId ^ (orderId >>> 32));
		result = prime * result + (int) (productId ^ (productId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderId other = (OrderId) obj;
		if (merchantId != other.merchantId)
			return false;
		if (orderId != other.orderId)
			return false;
		if (productId != other.productId)
			return false;
		return true;
	}
	
	
	
	
	
	

}
