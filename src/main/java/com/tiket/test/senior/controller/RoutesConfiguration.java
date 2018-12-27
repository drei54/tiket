package com.tiket.test.senior.controller;

import static org.springframework.web.reactive.function.server.RequestPredicates.method;
import static org.springframework.web.reactive.function.server.RequestPredicates.path;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;

import com.tiket.test.senior.model.Customer;
import com.tiket.test.senior.reactiverepository.ReactiveCustomerRepository;

@Configuration
public class RoutesConfiguration {
    @Bean
    RouterFunction<?> routes(ReactiveCustomerRepository customerReactiveRepository) {
        return nest(path("/reactive/customer"),

                route(RequestPredicates.GET("/{id}"),
                        request -> ok().body(customerReactiveRepository.findById(request.pathVariable("id")), Customer.class))

                        .andRoute(method(HttpMethod.POST),
                                request -> {
                                	customerReactiveRepository.insert(request.bodyToMono(Customer.class)).subscribe();
                                    return ok().build();
                                })
        );
    }
}