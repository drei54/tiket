package com.tiket.test.senior.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tiket.test.senior.model.Customer;
import com.tiket.test.senior.model.Employee;
import com.tiket.test.senior.model.Order;
import com.tiket.test.senior.model.OrderDetail;
import com.tiket.test.senior.model.Product;
import com.tiket.test.senior.model.ShippingMethod;
import com.tiket.test.senior.reactiverepository.ReactiveCustomerRepository;
import com.tiket.test.senior.reactiverepository.ReactiveEmployeeRepository;
import com.tiket.test.senior.reactiverepository.ReactiveOrderDetailRepository;
import com.tiket.test.senior.reactiverepository.ReactiveOrderRepository;
import com.tiket.test.senior.reactiverepository.ReactiveProductRepository;
import com.tiket.test.senior.reactiverepository.ReactiveShippingMethodRepository;

import reactor.core.publisher.Flux;

@RestController
public class ReactiveController {
	@Autowired
    private ReactiveCustomerRepository customerReactiveRepository;

	@Autowired
    private ReactiveEmployeeRepository employeeReactiveRepository;

	@Autowired
    private ReactiveProductRepository productReactiveRepository;
	
	@Autowired
    private ReactiveOrderRepository orderReactiveRepository;
	
	@Autowired
    private ReactiveOrderDetailRepository orderDetailReactiveRepository;

	@Autowired
    private ReactiveShippingMethodRepository shippingMethodReactiveRepository;

	@GetMapping("/reactive/customer")
    public Flux<Customer> customerIndex() {
        return customerReactiveRepository.findAll();
    }

	@GetMapping("/reactive/employee")
    public Flux<Employee> employeeIndex() {
        return employeeReactiveRepository.findAll();
    }

	@GetMapping("/reactive/product")
    public Flux<Product> productIndex() {
        return productReactiveRepository.findAll();
    }

	@GetMapping("/reactive/order")
    public Flux<Order> orderIndex(
    		@RequestParam(value = "page", defaultValue = "0") long page,
            @RequestParam(value = "size", defaultValue = "1") long size
            ) {
		Flux<Order> orders=  orderReactiveRepository.findAll()
//                .sort(comparing(Order::getCreatedDate).reversed())
                .skip(page * size).take(size);
		return orders;
    }

	@GetMapping("/reactive/order-detail")
    public Flux<OrderDetail> orderDetailIndex() {
        return orderDetailReactiveRepository.findAll();
    }

	@GetMapping("/reactive/shipping-method")
    public Flux<ShippingMethod> shippingMethodIndex() {
        return shippingMethodReactiveRepository.findAll();
    }

	
	/*	@GetMapping("/customer/{id}")
    public Mono<Customer> customerDetail(@PathVariable(value = "id") Long customerId) {
        return customerReactiveRepository.findBy(customerId);
    }
*/
}
