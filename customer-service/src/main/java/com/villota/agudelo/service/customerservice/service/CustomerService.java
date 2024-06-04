package com.villota.agudelo.service.customerservice.service;

import java.util.List;

import com.villota.agudelo.service.customerservice.model.CustomerVO;

public interface CustomerService {

    CustomerVO saveCustomer(CustomerVO customerVO) throws Exception;

    List<CustomerVO> getCustomers();

    CustomerVO getCustomer(String customerId);

    void updateCustomer(String customerId, CustomerVO customerVO) throws Exception;

    void deleteCustomer(String customerId) throws Exception;
}