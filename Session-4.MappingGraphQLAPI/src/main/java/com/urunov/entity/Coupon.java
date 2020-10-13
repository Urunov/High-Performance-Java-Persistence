package com.urunov.entity;

import com.urunov.entity.exist.CouponStatus;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Slf4j
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Coupon implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private int number_of_coupon;

    private int discount_in_present; //

    private String code;

    private int minimum_amount;

    private String description;

    private Date creation_date;

    @Enumerated(value = EnumType.ORDINAL)
    private CouponStatus status;

    /*** Product */
    //@OneToOne(mappedBy = "coupon", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)

    @ManyToOne(cascade = CascadeType.ALL)
    private Product product;

    /*** Category */


}
