package com.tiket.test.senior.reactiverepository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.tiket.test.senior.model.OrderDetail;

import reactor.core.publisher.Mono;


public interface ReactiveOrderDetailRepository extends ReactiveMongoRepository<OrderDetail, String> {
	Mono<OrderDetail> findByOrderDetailId(Long id);
//    Flux<Customer> findOneByFirstName(String name);
}