package com.tiket.test.senior.reactiverepository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.tiket.test.senior.model.ShippingMethod;

import reactor.core.publisher.Mono;


public interface ReactiveShippingMethodRepository extends ReactiveMongoRepository<ShippingMethod, String> {
	Mono<ShippingMethod> findByShippingMethodId(Long id);
//    Flux<Customer> findOneByFirstName(String name);
}