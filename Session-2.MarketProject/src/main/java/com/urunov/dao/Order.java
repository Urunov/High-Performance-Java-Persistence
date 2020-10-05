package com.urunov.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Order extends JpaRepository<Order, Long> {
}
