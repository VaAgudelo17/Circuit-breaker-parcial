package com.villota.agudelo.service.customerservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;

import com.villota.agudelo.service.customerservice.entity.Customer;
import com.villota.agudelo.service.customerservice.model.Customer;
import com.villota.agudelo.service.customerservice.model.exception.NotFoundException;
import com.villota.agudelo.service.customerservice.repository.CustomerRepository;
import com.villota.agudelo.service.customerservice.service.CustomerService;

import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

@Slf4j
@Component
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(Customer customerVO) throws Exception {
        customerVO.setCustomerId(Strings.isBlank(customerVO.getCustomerId()) ? UUID.randomUUID().toString() : customerVO.getCustomerId());
        Customer customer = Customer.builder()
                .customerId(customerVO.getCustomerId())
                .firstName(customerVO.getFirstName())
                .lastName(customerVO.getLastName())
                .build();
        customerRepository.save(customer);
        return customerVO;
    }

    @Override
    public Customer getCustomer(String customerId) {
        Customer customer =
                customerRepository.findByCustomerId(customerId).orElseThrow(() ->
                        new NotFoundException("Could not find customer with customerId: " + customerId));

        Customer customerVO = Customer.builder()
                .customerId(customerId)
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .build();
        return customerVO;
    }

    @Override
    public List<Customer> getCustomers() {
        List<Customer> customers = customerRepository.findAll();

        List<Customer> customerVOS = customers.stream()
                .map(customer -> Customer.builder()
                        .customerId(customer.getCustomerId())
                        .firstName(customer.getFirstName())
                        .lastName(customer.getLastName())
                        .build())
                .collect(toList());

        return customerVOS;
    }

    @Override
    public void updateCustomer(String customerId, Customer customerVO) throws Exception {
        Customer customer =
                customerRepository.findByCustomerId(customerId).orElseThrow(() ->
                        new NotFoundException("Could not find customer with customerId: " + customerId));
        customer.setFirstName(customerVO.getFirstName());
        customer.setLastName(customerVO.getLastName());
        customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(String customerId) throws Exception {
        Customer customer =
                customerRepository.findByCustomerId(customerId).orElseThrow(() ->
                        new NotFoundException("Could not find customer with customerId: " + customerId));
        customerRepository.delete(customer);
    }
}
