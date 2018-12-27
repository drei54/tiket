package com.tiket.test.intermediate.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.tiket.test.intermediate.entity.Product;


@Transactional
public interface ProductDao extends CrudRepository<Product, Long> {
	
	public Product findByProductId(long Id);

	public Product findByProductName(String productName);

	public Page<Product> findAll(Pageable pageable);
	
}
