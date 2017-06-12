package com.coviam.blabla.order.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.coviam.blabla.order.entity.OrderId;
import com.coviam.blabla.order.entity.OrderItem;

public interface OrderItemRepository extends CrudRepository<OrderItem, OrderId> {
	
	public List<OrderItem> findByOrderId(long orderId);

}
