package com.urunov.rest.controller;


import com.urunov.rest.exceptions.ResourceNotFoundException;
import com.urunov.rest.model.Coupon;
import com.urunov.rest.model.User;
import com.urunov.rest.repository.CouponResource;
import com.urunov.rest.repository.UserResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.module.ResolutionException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/app/v1/")
public class CouponController {


    @Autowired
    private CouponResource couponResource;

    @GetMapping("/coupon")
    public List<Coupon> getAllUser(){
        return couponResource.findAll();
    }

    @GetMapping("/coupon/{id}")
    public ResponseEntity<Coupon> getCouponById(@PathVariable(value = "id") Long couponId) throws ResourceNotFoundException {

        Coupon coupon = couponResource.findById(couponId).orElseThrow(() -> new ResourceNotFoundException("Product not found for this"+ couponId));
        return ResponseEntity.ok().body(coupon);
    }

    @PostMapping("/coupon")
    public Coupon createCoupon(@Valid @RequestBody Coupon coupon){
        return couponResource.save(coupon);
    }

    @PutMapping("/coupon/{id}")
    public ResponseEntity<Coupon> updateCoupon(@PathVariable(value = "id") Long couponId,
                                           @Valid @RequestBody Coupon couponDetails) throws ResourceNotFoundException{
        //
        Coupon coupon = couponResource.findById(couponId).orElseThrow(()-> new ResolutionException("Product not found for this" + couponId));

        coupon.setTitle(couponDetails.getTitle());
        coupon.setCode(couponDetails.getCode());
        coupon.setTitle(couponDetails.getTitle());
        coupon.setDescription(couponDetails.getDescription());
        coupon.setDiscount_in_prosent(couponDetails.getDiscount_in_prosent());
        coupon.setMinimum_amount(couponDetails.getMinimum_amount());
        coupon.setCreation_date(couponDetails.getCreation_date());


        final Coupon updateCoupon = couponResource.save(coupon);
        return ResponseEntity.ok(updateCoupon);
    }

    @DeleteMapping("/coupon/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long couponId) throws ResourceNotFoundException{


        Coupon coupon = couponResource.findById(couponId)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not found for this id::" + couponId));

        couponResource.delete(coupon);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
