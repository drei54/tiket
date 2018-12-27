package com.tiket.test.intermediate.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.tiket.test.intermediate.entity.Employee;


@Transactional
public interface EmployeeDao extends CrudRepository<Employee, Long> {
	
	public Employee findByEmployeeId(long Id);

	public Employee findByFirstName(String name);

	public Page<Employee> findAll(Pageable pageable);
	
}
