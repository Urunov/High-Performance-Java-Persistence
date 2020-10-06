package com.urunov.input;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

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
    private String address;

    @ManyToMany(mappedBy = "customers")
    private Collection<Orders> orders = new ArrayList<>();
}
