package com.urunov.repository;

import com.urunov.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerResource extends JpaRepository<Customer, Long> {
}
