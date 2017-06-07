package com.coviam.blabla.order.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coviam.blabla.order.dao.OrderItemRepository;
import com.coviam.blabla.order.dao.OrderRepository;
import com.coviam.blabla.order.dto.ItemDetail;
import com.coviam.blabla.order.dto.OrderAndItems;
import com.coviam.blabla.order.dto.Product;
import com.coviam.blabla.order.entity.Order;
import com.coviam.blabla.order.entity.OrderItem;
import com.coviam.blabla.order.helper.OrderAndItemHelper;
import org.springframework.context.annotation.PropertySource;


@PropertySource("classpath:application.properties")
@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderRepository orderrepository;
	@Autowired
	private OrderItemRepository orderitemrepository;
	
	@Override
	public Order saveOrder(OrderAndItems orderanditems) {
		Order order = OrderAndItemHelper.createOrder(orderanditems);
		Order savedOrder = orderrepository.save(order);
		return savedOrder;
		
	}
	

	@Override
	public OrderItem saveOrderItems(OrderAndItems orderanditems, long orderId) {
		List<Product> productListForMerchantMicroService =  new ArrayList<Product>();
		List<OrderItem> orderitems = OrderAndItemHelper.createOrderItem(orderanditems, orderId);
		for(OrderItem orderitem : orderitems){
			OrderItem savedOrderItem = orderitemrepository.save(orderitem);
			productListForMerchantMicroService.add(new Product(orderitem));
			}
		
		return null;
	}

	@Override
	public void deleteOrder(long orderId) {
		orderrepository.delete(orderId);
		
	}

	@Override
	public Order getOrder(long orderId) {
		Order order = orderrepository.findOne(orderId);
		return order;
	}


	@Override
	public void setMerchantRating(float merchantRating) {
	}
	
	@Override
	public List<OrderAndItems> fetchOrderHistory(String email) {
		List<OrderAndItems> orderanditemslist = new ArrayList<OrderAndItems>();
		//Fetch orders
		List<Order> orderHistory = orderrepository.findByEmailId(email);
		//Fetch order items
		
		for(Order order : orderHistory){
			
			List<ItemDetail> itemdetail = new ArrayList<ItemDetail>();
			long orderId = order.getOrderId();
			List<OrderItem> orderItemsHistory = orderitemrepository.findByOrderId(orderId);
			for(OrderItem orderitem : orderItemsHistory){
				itemdetail.add(new ItemDetail(orderitem));
			}
		orderanditemslist.add(new OrderAndItems(order, itemdetail));
			
		}
		return orderanditemslist;
	}



	

}
