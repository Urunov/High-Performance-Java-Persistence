package com.urunov.input;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @Author: apple
 * @created on 21/09/2020
 * @Project is Project
 */

@Data
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product implements Serializable {


    /*** Declare Variables*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true)
    private Long product_id;

    @Column(name = "product_name")
    private String name;

    private String image;
    private String slug;
    private String type;
    private String unit;
    private int price;
    private double salePrice; // nullable=true
    private Integer disc_in_pros; // default =0
    private Integer per_unit;  // default =1
    private Integer quantity; //
    private String description;


    private Date creation_date;

    /*** Mapping with Hibernate**/

    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "product_order",
            joinColumns = {@JoinColumn(name = "product_id")}, // product
            inverseJoinColumns = {@JoinColumn(name = "order_id")} // order
    )
    private List<Orders> orders = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    private Coupon coupon;

}
