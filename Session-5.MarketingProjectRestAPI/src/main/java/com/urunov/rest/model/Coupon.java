package com.urunov.rest.model;

import com.urunov.rest.model.exist.CouponStatus;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Coupon implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private int discount_in_prosent;

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
