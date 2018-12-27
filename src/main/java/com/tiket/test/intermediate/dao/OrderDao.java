package com.tiket.test.intermediate.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.tiket.test.intermediate.entity.Order;


@Transactional
public interface OrderDao extends CrudRepository<Order, Long> {
	
	public Order findByOrderId(long Id);

	public List<Order> findByCustomerCustomerId(long customerId);

	public Page<Order> findAll(Pageable pageable);
	
}
