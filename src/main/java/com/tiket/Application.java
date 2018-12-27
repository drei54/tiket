package com.tiket;

import org.springframework.boot.CommandLineRunner;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.tiket.test.senior.model.ShippingMethod;
import com.tiket.test.senior.reactiverepository.ReactiveShippingMethodRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@EntityScan({"com.tiket.test"})
@ComponentScan("com.tiket.test")
@EnableTransactionManagement
@Configuration
@EnableReactiveMongoRepositories
@SpringBootApplication
public class Application extends SpringBootServletInitializer{

//	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}
	
	@Bean
    public CommandLineRunner demo(ReactiveShippingMethodRepository repository) {
//        final ShippingMethod shippingMethod1 = new ShippingMethod(11l,"Federal Express");
//        repository.saveAll(Flux.just(shippingMethod1)).subscribe();
//		repository.save(new ShippingMethod(2, "Test")).subscribe();
//        repository.deleteAll().subscribe();
//        repository.saveAll(Mono.just(shippingMethod1)).subscribe();

        return (args) -> {
//			// save students
//			repository.save(new ShippingMethod(2, "Test"));
		};
    }

}
