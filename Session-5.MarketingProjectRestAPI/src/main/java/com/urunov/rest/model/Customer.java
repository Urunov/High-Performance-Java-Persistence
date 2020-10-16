package com.urunov.rest.model;

import com.urunov.rest.model.info.Address;
import com.urunov.rest.model.info.Card;
import com.urunov.rest.model.info.Contact;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
