package com.villota.agudelo.service.customerserviceclient.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreakerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.villota.agudelo.service.customerserviceclient.model.Customer;

import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
@Slf4j
@RequiredArgsConstructor
public class CustomerClientController {

    private final WebClient webClient;
    private final ReactiveCircuitBreakerFactory reactiveCircuitBreakerFactory;

    @PostMapping("/customers")
    public Mono<Customer> createCustomer(Customer customerVO){
        return webClient.post()
                .uri("/customers")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(customerVO), Customer.class)
                .retrieve()
                .bodyToMono(Customer.class)
                .timeout(Duration.ofMillis(10_000))
                .transform(it -> {
                    ReactiveCircuitBreaker rcb = reactiveCircuitBreakerFactory.create("customer-service");
                    return rcb.run(it, throwable -> Mono.just(Customer.builder().build()));
                });
    }

    @GetMapping("/customers/{customerId}")
    public Mono<Customer> getCustomer(@PathVariable String customerId) {
        return webClient
                .get().uri("/customers/" + customerId)
                .retrieve()
                .bodyToMono(Customer.class)
                .transform(it -> {
                    ReactiveCircuitBreaker rcb = reactiveCircuitBreakerFactory.create("customer-service");
                    return rcb.run(it, throwable -> Mono.just(Customer.builder().build()));
                });
    }

    @PutMapping("/customers/{customerId}")
    public Mono<Customer> updateCustomer(@PathVariable String customerId, Customer customerVO){
        return webClient.put()
                .uri("/customers/" + customerVO.getCustomerId())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(customerVO), Customer.class)
                .retrieve()
                .bodyToMono(Customer.class)
                .transform(it -> {
                    ReactiveCircuitBreaker rcb = reactiveCircuitBreakerFactory.create("customer-service");
                    return rcb.run(it, throwable -> Mono.just(Customer.builder().build()));
                });
    }

    @DeleteMapping("/customers/{customerId}")
    public Mono<String> deleteCustomer(@PathVariable String customerId){
        return webClient.delete()
                .uri("/customers/" + customerId)
                .retrieve()
                .bodyToMono(String.class)
                .transform(it -> {
                    ReactiveCircuitBreaker rcb = reactiveCircuitBreakerFactory.create("customer-service");
                    return rcb.run(it, throwable -> Mono.just(customerId));
                });
    }
}
