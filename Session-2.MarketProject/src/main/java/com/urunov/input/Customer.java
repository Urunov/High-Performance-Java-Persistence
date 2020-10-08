package com.urunov.input;

import com.urunov.input.info.Address;
import com.urunov.input.info.Card;
import com.urunov.input.info.Contact;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
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
@ToString
@Entity
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long custom_id;

    private String name;
    private String image;
    private String email;
    private int totalOrder;
    private int totalOrderAmount;


    @ManyToMany(mappedBy = "customers")
    private Collection<Orders> orders = new ArrayList<>();

    //Address
    @OneToMany(mappedBy = "customer")
    private List<Address> addresses;

    //Contact
    @OneToMany(mappedBy = "customer")
    private List<Contact> contact;

    // Card
    @OneToMany(mappedBy = "customer")
    private List<Card> card;
}
