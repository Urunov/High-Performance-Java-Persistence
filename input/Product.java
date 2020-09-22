//package com.urunov.input;
//
//import lombok.*;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Set;
//
///**
// * @Author: apple
// * @created on 21/09/2020
// * @Project is Project
// */
//
//@Data
//@Setter
//@Getter
//@ToString
//@AllArgsConstructor
//@NoArgsConstructor
//
//@Entity
//public class Product implements Serializable {
//
//
//    /*** Declare Variables*/
//    @Id
//    private Long id;
//
//    private String productName;
//    private String image;
//    private String slug;
//    private String type;
//    private String unit;
//    private int price;
//    private float salePrice; // nullable=true
//    private int disc_in_pros; // default =0
//    private int per_unit;  // default =1
//    private int quantity; //
//    private String description;
//    private Date creation_date;
//
//    /*-----------------------------------*/
//
//    /*** Mapping Technic and Hibernate**/
//
//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinTable(name = "procat_id")
//    private Category category;
//
////    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
////    @JoinTable(name = "proorder_id")
////    private List<Order> orders = new ArrayList<Order>();
////    /*-----------------------------------*/
////
//
//
//}
