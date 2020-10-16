package com.urunov.rest.repository;

import com.urunov.rest.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponResource extends JpaRepository<Coupon, Long> {
}
