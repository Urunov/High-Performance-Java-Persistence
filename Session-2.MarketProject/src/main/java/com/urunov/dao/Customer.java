package com.urunov.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Customer extends JpaRepository<Customer, Long> {
}
