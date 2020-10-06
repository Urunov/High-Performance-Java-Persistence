package com.urunov.dataresource;

import com.urunov.input.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersResource extends JpaRepository<Orders, Long> {
}
