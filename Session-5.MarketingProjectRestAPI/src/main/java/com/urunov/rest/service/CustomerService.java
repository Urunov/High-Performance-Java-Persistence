package com.urunov.rest.service;

import org.springframework.stereotype.Service;

@Service
public interface CustomerService {

    //public CustomerService validateUsers(String userName, String password);

//  Integer register void User(CustomerService customer);

   // boolean changePassword(String password1, CustomerService customer);

    CustomerService getCustomerById(Long customerId);

    Long getCustomerName(String userName);


}
