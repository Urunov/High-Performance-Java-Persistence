package com.urunov.repository;

import com.urunov.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponResource extends JpaRepository<Coupon, Long> {
}
