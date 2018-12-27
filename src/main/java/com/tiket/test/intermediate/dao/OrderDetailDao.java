package com.tiket.test.intermediate.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.tiket.test.intermediate.entity.OrderDetail;


@Transactional
public interface OrderDetailDao extends CrudRepository<OrderDetail, Long> {
	
	public OrderDetail findByOrderDetailId(long Id);

	public List<OrderDetail> findByOrderOrderId(long orderId);

	public Page<OrderDetail> findAll(Pageable pageable);
	
}
