package com.villota.agudelo.service.customerservice.service;

import java.util.List;

import com.villota.agudelo.service.customerservice.model.Customer;

public interface CustomerService {

    Customer saveCustomer(Customer customerVO) throws Exception;

    List<Customer> getCustomers();

    Customer getCustomer(String customerId);

    void updateCustomer(String customerId, Customer customerVO) throws Exception;

    void deleteCustomer(String customerId) throws Exception;
}