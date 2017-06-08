package com.coviam.blabla.order.service;

import java.util.List;

import com.coviam.blabla.order.dto.OrderAndItems;
import com.coviam.blabla.order.dto.Product;
import com.coviam.blabla.order.dto.ProductQty;
import com.coviam.blabla.order.entity.Order;
import com.coviam.blabla.order.entity.OrderItem;


public interface OrderService {
	
	public Order saveOrder(OrderAndItems orderanditems);
	
	public void deleteOrder(long orderid);
	
	public Order getOrder(long orderId);
	
	public List<OrderItem> saveOrderItems(OrderAndItems orderanditems, long orderId);
	
	public void setMerchantRating(float merchantRating);

	public List<OrderAndItems> fetchOrderHistory(String email);
	
	public boolean sendOrderConfirmationEmail(long orderId, OrderAndItems orderanditems);

	public List<ProductQty> updateStockinProductMicroService(List<OrderItem> savedOrderItems);
	
	public List<OrderAndItems> getProductAndMerchantDetalsfromProductMicroService(List<OrderAndItems> orderanditemshistory);

	List<Product> updateProductRatingQuantityinMerchantMicroService(List<OrderItem> savedOrderItems);
	
}
