package com.urunov.dataresource;

import com.urunov.input.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerResource extends JpaRepository<Customer, Long> {
}
