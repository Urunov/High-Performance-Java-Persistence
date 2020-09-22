//package com.urunov.input;
//
//import lombok.*;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.util.Date;
//import java.util.List;
//
///**
// * @Author: apple
// * @created on 21/09/2020
// * @Project is Project
// */
//@Data
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//public class Order implements Serializable {
//
//    /*** Declare Variables*/
//
//
//    @Id
//    @Generated
//    private Long id;
//
//    private Double amount;
//
//    private String paymentMethod;
//    private String contactNumber;
//    private String deliveryAddress;
//    private String status;
//    private String description;
//    private String discount;
//    private Double deliveryFee;
//    private Date creationDate;
//
//
//    /*-----------------------------------*/
//
//    /*** Mapping Technic and Hibernate**/
//
//    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "orders")
//    private List<Product> productList;
//
//    @ManyToOne
//    @JoinTable(catalog = "cusorder_id")
//    private Customer customer;
//
//}
