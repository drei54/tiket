package com.tiket.test.intermediate.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.tiket.test.intermediate.entity.Customer;


@Transactional
public interface CustomerDao extends CrudRepository<Customer, Long> {
	
	public Customer findByCustomerId(long Id);

	public Customer findByFirstName(String name);

	public Page<Customer> findAll(Pageable pageable);
	
}
