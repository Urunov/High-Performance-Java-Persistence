package com.urunov.rest.controller;

import com.urunov.rest.exceptions.ResourceNotFoundException;
import com.urunov.rest.model.Customer;
import com.urunov.rest.repository.CustomerResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class CustomerController {

    @Autowired
    private CustomerResource customerResource;

    @GetMapping("/customer")
    private List<Customer> getAllCustomers(){
        return customerResource.findAll();
    }

    @GetMapping("/customer/")
    public ResponseEntity<Customer> getCustomerById(@PathVariable(value = "id") Long customerId) throws ResourceNotFoundException {

        Customer customer = customerResource.findById(customerId)
                .orElseThrow(()-> new ResourceNotFoundException("Cusomter not found for this: " + customerId));
        return ResponseEntity.ok().body(customer);
    }

    @PostMapping("/customer")
    public Customer createCustomer(@Valid @RequestBody Customer customer) {
        return customerResource.save(customer);
    }



}
