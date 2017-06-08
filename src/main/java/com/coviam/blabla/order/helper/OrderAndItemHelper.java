package com.coviam.blabla.order.helper;

import java.util.ArrayList;
import java.util.List;

import com.coviam.blabla.order.dto.ItemDetail;
import com.coviam.blabla.order.dto.OrderAndItems;
import com.coviam.blabla.order.dto.Product;
import com.coviam.blabla.order.dto.ProductQty;
import com.coviam.blabla.order.entity.Order;
import com.coviam.blabla.order.entity.OrderItem;


public class OrderAndItemHelper {

	public static Order createOrder(OrderAndItems orderanditems) {
		Order order = new Order();
		order.setEmailId(orderanditems.getEmailId());
		order.setDate(orderanditems.getDate());
		return order;
	}
	
	public static List<OrderItem> createOrderItem(OrderAndItems orderanditems, long orderId) {
		
		List<ItemDetail> itemdetaillist = orderanditems.getProductList();
		List<OrderItem> orderitemlist = new ArrayList<OrderItem>();
		for(ItemDetail itemdetail : itemdetaillist){
		OrderItem orderitem = new OrderItem();
		orderitem.setOrderId(orderId);
		orderitem.setProductId(itemdetail.getProductId());
		orderitem.setMerchantId(itemdetail.getMerchantId());
		orderitem.setQuantity(itemdetail.getQuantity());
		orderitem.setPrice(itemdetail.getPrice());
		orderitem.setRating(itemdetail.getRating());
		orderitem.setReviews(itemdetail.getReviews());
		orderitemlist.add(orderitem);
		}
		return orderitemlist;
	}
	
	public static String createEmailText(List<OrderItem> orderitemlist){
		
		StringBuffer emailText = new StringBuffer();
		emailText.append("The details of your order are:\n\n")
				 .append("Order ID : ")
				 .append(orderitemlist.get(0).getOrderId())
				 .append("\n\n")
				 .append("Products:\n\n");
		for(OrderItem orderitem : orderitemlist){
			emailText.append("Product ID : ")
					 .append(orderitem.getProductId())
					 .append("\n\n")
					 .append("Quantity : ")
					 .append(orderitem.getQuantity())
					 .append("\n\n");
		}
		return emailText.toString();
	}

	public static ProductQty createProductQtyDto(OrderItem orderitem) {
		ProductQty productqty = new ProductQty(orderitem);
		return productqty;
	}
	
	public static Product createProductQtyRatingDto(OrderItem orderitem){
		Product product = new Product(orderitem);
		return product;
	}
	
	
}
