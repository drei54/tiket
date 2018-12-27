package com.tiket.test.senior.reactiverepository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.tiket.test.senior.model.Product;

import reactor.core.publisher.Mono;


public interface ReactiveProductRepository extends ReactiveMongoRepository<Product, String> {
	Mono<Product> findByProductId(Long id);
//    Flux<Customer> findOneByFirstName(String name);
}