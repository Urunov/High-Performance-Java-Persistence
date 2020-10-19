package com.urunov.rest.service;

import com.urunov.rest.exceptions.ResourceNotFoundException;
import com.urunov.rest.model.Customer;

import javax.persistence.criteria.Order;
import java.util.List;
import java.util.Map;


public interface CustomerService {


    Customer customById(Long customId);

    List<Customer> getAllCustomers();

    void addCustomer(Customer customer, long id);
    Order updateCustomer(long id, Customer customerDetails) throws ResourceNotFoundException;
    Map<String, Boolean> deleteCustomerById(long id) throws ResourceNotFoundException;


}
