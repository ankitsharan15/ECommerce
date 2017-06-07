package com.coviam.blabla.order.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import com.coviam.blabla.order.dto.OrderAndItems;
import com.coviam.blabla.order.entity.Order;
import com.coviam.blabla.order.service.OrderService;

@Controller
public class OrderController {
	
	@Autowired
	OrderService orderservice;
	
	@RequestMapping(value = "/orders/checkout", method = RequestMethod.POST)
	@ResponseBody
	public boolean saveOrder(OrderAndItems orderanditems){
		
		Order savedOrder = orderservice.saveOrder(orderanditems);
		long orderId = savedOrder.getOrderId();
		orderservice.saveOrderItems(orderanditems, orderId);
		return true;
		}
	
	@RequestMapping(value = "/orders/history", method = RequestMethod.POST)
	@ResponseBody
	public List<OrderAndItems> fetchOrderHistory(String email){
		List<OrderAndItems> orderHistory = orderservice.fetchOrderHistory(email);
		if(orderHistory.size() == 0)
			return null;
		return orderHistory;
	}

	

}
