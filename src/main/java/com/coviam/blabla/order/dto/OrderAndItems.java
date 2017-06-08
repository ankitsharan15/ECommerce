package com.coviam.blabla.order.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.coviam.blabla.order.entity.Order;

public class OrderAndItems implements Serializable{
	
	private String emailId;
	
	private Date date;
	
	private List<ItemDetail> productList;
	
	
	public OrderAndItems() {
		super();
		
	}

	public OrderAndItems(Order order, List<ItemDetail> itemdetails) {
		super();
		this.emailId = order.getEmailId();
		this.date = order.getDate();
		this.productList = itemdetails;
		
	}

	

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<ItemDetail> getProductList() {
		return productList;
	}

	public void setProductList(List<ItemDetail> productList) {
		this.productList = productList;
	}
	
	

}
