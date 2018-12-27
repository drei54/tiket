package com.tiket.test.senior.reactiverepository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.tiket.test.senior.model.Order;

import reactor.core.publisher.Mono;


public interface ReactiveOrderRepository extends ReactiveMongoRepository<Order, String> {
	Mono<Order> findByOrderId(Long id);
//    Flux<Customer> findOneByFirstName(String name);
}