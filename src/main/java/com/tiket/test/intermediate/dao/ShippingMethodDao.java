package com.tiket.test.intermediate.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.tiket.test.intermediate.entity.ShippingMethod;


@Transactional
public interface ShippingMethodDao extends CrudRepository<ShippingMethod, Long> {
	
	public ShippingMethod findByShippingMethodId(long Id);

	public ShippingMethod findByShippingMethod(String shippingMethod);

	public Page<ShippingMethod> findAll(Pageable pageable);
	
}
