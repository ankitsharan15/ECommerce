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
	
	public static String createEmailText(long orderId, List<ItemDetail> orderitemlist){
		
		float total= 0;
		//Formatter formatter = new Formatter();
		StringBuffer emailText = new StringBuffer();
			emailText.append("Hi, \n\n Your order has been confirmed with Order Id ")
					.append(orderId)
					.append(".")
					.append("\n\nPlease find below the details of your order:\n\n")
					.append(String.format("%1$-30s%2$-30s%3$-30s%4$-30s%5$-30s","Product","Seller","Quantity","Unit price","Amount"))
					.append("\n\n");
			
		for(ItemDetail orderitem : orderitemlist){
			//formatter = new Formatter();
			total = total + (orderitem.getQuantity()*orderitem.getPrice());
			emailText.append(String.format("%1$-30s%2$-30s%3$-30s%4$-30s%5$-30s",orderitem.getProductName(), orderitem.getMerchantName(), orderitem.getQuantity(), orderitem.getPrice(), orderitem.getQuantity()*orderitem.getPrice()))
					 .append("\n");
					 
			}
		//formatter = new Formatter();
		emailText.append(String.format("%150s", "---------------"));
		//formatter = new Formatter();
		emailText.append(String.format("%150s", total))
				 .append("\n\nWe would love to see you again!\n\n\nRegards\n")
		 		 .append("Team BlaBla");
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
