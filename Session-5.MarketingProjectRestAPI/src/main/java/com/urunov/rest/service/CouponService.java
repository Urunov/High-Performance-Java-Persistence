package com.urunov.rest.service;

import com.urunov.rest.exceptions.ResourceNotFoundException;
import com.urunov.rest.model.Coupon;
import com.urunov.rest.model.Customer;

import javax.persistence.criteria.Order;
import java.util.List;
import java.util.Map;

public interface CouponService {

    Coupon couponById(Long couponId);

    List<Coupon> getAllCoupon();

    void addCoupon(Coupon coupon, long id);
    Order updateCustomer(long id, Coupon couponDetail) throws ResourceNotFoundException;
    Map<String, Boolean> deleteCouponById(long id) throws ResourceNotFoundException;

}
