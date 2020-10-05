package com.urunov.input;

import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

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
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order")
public class Order implements Serializable {

    /*** Declare Variables*/


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long order_Id;

    private Float amount;

    private String paymentMethod;
    private String contactNumber;
    private String deliveryAddress;
    private String status;
    private String description;
    private String discount;
    private Float deliveryFee;
    private Date creationDate;

    /*** Mapping Technic and Hibernate**/

     @ManyToMany(cascade = CascadeType.ALL)
     @JoinTable(name = "custom_order",
             joinColumns = {@JoinColumn(name = "order_Id")},
             inverseJoinColumns = {@JoinColumn(name = "customer_Id")}
             )

     private Collection<Customer> customers = new ArrayList<>();


//    @ManyToMany(cascade = CascadeType.ALL)
//    private Set<Product> products;


}
