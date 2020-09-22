//package com.urunov.input;
//
//import lombok.*;
//
//import javax.persistence.*;
//import java.io.Serializable;
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
//@ToString
//@Entity
//public class Customer implements Serializable {
//
//    @Id
//    private Long id;
//
//    private String name;
//    private String image;
//    private String email;
//    private int totalOrder;
//    private int totalOrderAmount;
//    private String address;
//
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
//    private List<Order> orderList;
//}
