package com.tiket.test.senior.reactiverepository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.tiket.test.senior.model.Customer;

import reactor.core.publisher.Mono;


public interface ReactiveCustomerRepository extends ReactiveMongoRepository<Customer, String> {
	Mono<Customer> findByCustomerId(Long id);
//    Flux<Customer> findOneByFirstName(String name);
}