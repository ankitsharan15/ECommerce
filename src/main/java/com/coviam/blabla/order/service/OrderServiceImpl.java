package com.coviam.blabla.order.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.coviam.blabla.order.dao.OrderItemRepository;
import com.coviam.blabla.order.dao.OrderRepository;
import com.coviam.blabla.order.dto.ItemDetail;
import com.coviam.blabla.order.dto.OrderAndItems;
import com.coviam.blabla.order.dto.Product;
import com.coviam.blabla.order.dto.ProductQty;
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
	@Autowired
	private EmailService emailservice;
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	@Transactional
	public Order saveOrder(OrderAndItems orderanditems) {
		Order order = OrderAndItemHelper.createOrder(orderanditems);
		Order savedOrder = orderrepository.save(order);
		return savedOrder;
		
	}
	

	@Override
	@Transactional
	public List<OrderItem> saveOrderItems(OrderAndItems orderanditems, long orderId) {
		List<OrderItem> savedOrderItemList = new ArrayList<OrderItem>();
		List<OrderItem> orderitems = OrderAndItemHelper.createOrderItem(orderanditems, orderId);
		for(OrderItem orderitem : orderitems){
			OrderItem savedOrderItem = orderitemrepository.save(orderitem);
			savedOrderItemList.add(savedOrderItem);
			}
		
		return savedOrderItemList;
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
		orderanditemslist = getProductAndMerchantDetalsfromProductMicroService(orderanditemslist);
		
		return orderanditemslist;
	}


	@Override
	public boolean sendOrderConfirmationEmail(long orderId, OrderAndItems orderanditems) {
		
		String emailtext = OrderAndItemHelper.createEmailText(orderId, orderanditems.getProductList());
		emailservice.sendSimpleMessage(orderanditems.getEmailId(), "Order confirmation", emailtext);
		return true;
	}



	@Override
	public List<ProductQty> updateStockinProductMicroService(List<OrderItem> savedOrderItems) {
		
		final String uri = "http://172.16.20.36:8080/updateStock";
		
		List<ProductQty> productqtylist = new ArrayList<ProductQty>();
		for(OrderItem orderitem : savedOrderItems){
			ProductQty productqty = OrderAndItemHelper.createProductQtyDto(orderitem);
			productqtylist.add(productqty);
		}
	    
		ProductQty[] result = restTemplate.postForObject( uri, productqtylist, ProductQty[].class);
	    return productqtylist;
	}

	
	@Override
	public List<Product> updateProductRatingQuantityinMerchantMicroService(List<OrderItem> savedOrderItems) {
		
		final String uri = "http://172.16.20.34:8080/updateScorefromOrder";
		
		List<Product> productlist = new ArrayList<Product>();
		for(OrderItem orderitem : savedOrderItems){
			Product product = OrderAndItemHelper.createProductQtyRatingDto(orderitem);
			productlist.add(product);
		}
	    
		Product[] result = restTemplate.postForObject( uri, productlist, Product[].class);
	    return productlist;
	}


	@Override
	public List<OrderAndItems> getProductAndMerchantDetalsfromProductMicroService(List<OrderAndItems> orderanditemshistory) {
		
		final String uri = "http://172.16.20.36:8080/getproductmerchant";
		
		OrderAndItems[] result = restTemplate.postForObject(uri, orderanditemshistory , OrderAndItems[].class);
		
		List<OrderAndItems> resultList = Arrays.asList(result);
		
		return resultList;
		}
	
}
