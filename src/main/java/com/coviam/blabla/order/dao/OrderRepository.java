package com.coviam.blabla.order.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.coviam.blabla.order.entity.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {

	List<Order> findByEmailId(String email);

}
