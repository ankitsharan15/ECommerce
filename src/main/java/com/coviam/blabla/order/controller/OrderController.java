package com.coviam.blabla.order.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import com.coviam.blabla.order.dto.OrderAndItems;
import com.coviam.blabla.order.entity.Order;
import com.coviam.blabla.order.entity.OrderItem;
import com.coviam.blabla.order.service.OrderService;
import java.util.Date;
import java.util.ArrayList;
import com.coviam.blabla.order.dto.ItemDetail;

@Controller
public class OrderController {
	
	@Autowired
	OrderService orderservice;
	
	@RequestMapping(value = "/orders/checkout", method = RequestMethod.POST)
	@ResponseBody
	public boolean saveOrder(@RequestBody OrderAndItems orderanditems){
		//Test
		/*OrderAndItems testobj = new OrderAndItems();
		testobj.setEmailId("neelasha.sen@gmail.com");
		Date date = new Date();
		testobj.setDate(date);
		List<ItemDetail> testlist = new ArrayList<ItemDetail>();
		ItemDetail item1 = new ItemDetail();
		item1.setMerchantId(4);
		item1.setProductId(544);
		item1.setPrice((float)450.9);
		item1.setQuantity(2);
		item1.setRating(4);
		item1.setReviews("Awesome service");
		testlist.add(item1);
		testobj.setProductList(testlist);
		ItemDetail item2 = new ItemDetail();
		item2.setMerchantId(2);
		item2.setProductId(768);
		item2.setPrice((float)450.9);
		item2.setQuantity(7);
		item2.setRating(2);
		item2.setReviews("Poor");
		testlist.add(item2);*/
		//Test
		Order savedOrder = orderservice.saveOrder(orderanditems);
		long orderId = savedOrder.getOrderId();
		List<OrderItem> savedOrderItems = orderservice.saveOrderItems(orderanditems, orderId);
		orderservice.updateStockinProductMicroService(savedOrderItems);
		orderservice.sendOrderConfirmationEmail(savedOrder.getEmailId(), savedOrderItems);
		return true;
		}
	
	@RequestMapping(value = "/orders/history", method = RequestMethod.POST)
	@ResponseBody
	public List<OrderAndItems> fetchOrderHistory(@RequestBody String email){
		List<OrderAndItems> orderHistory = orderservice.fetchOrderHistory(email);
		if(orderHistory.size() == 0)
			return null;
		return orderHistory;
	}

	

}
