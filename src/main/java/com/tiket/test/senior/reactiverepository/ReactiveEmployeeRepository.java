package com.tiket.test.senior.reactiverepository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.tiket.test.senior.model.Employee;

import reactor.core.publisher.Mono;


public interface ReactiveEmployeeRepository extends ReactiveMongoRepository<Employee, String> {
	Mono<Employee> findByEmployeeId(Long id);
//    Flux<Customer> findOneByFirstName(String name);
}