package com.urunov.input;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Data
@Getter
@Setter
@AllArgsConstructor
@Slf4j
@NoArgsConstructor
@ToString
@Entity
public class Orders implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long order_id;

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
            joinColumns = {@JoinColumn(name = "order_id")}, // order
            inverseJoinColumns = {@JoinColumn(name = "custom_id")} // customer
    )
    private List<Customer> customers;



    @ManyToMany(mappedBy = "orders")
    private List<Product> products;
}
