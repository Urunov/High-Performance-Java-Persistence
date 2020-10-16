package com.urunov.rest.repository;

import com.urunov.rest.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersResource extends JpaRepository<Orders, Long> {
}
