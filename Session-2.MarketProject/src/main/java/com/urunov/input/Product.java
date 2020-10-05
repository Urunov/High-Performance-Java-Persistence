package com.urunov.input;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

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
@Table(name = "product")
public class Product implements Serializable {


    /*** Declare Variables*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;
    private String image;
    private String slug;
    private String type;
    private String unit;
    private int price;
    private float salePrice; // nullable=true
    private int disc_in_pros; // default =0
    private int per_unit;  // default =1
    private int quantity; //
    private String description;
    private Date creation_date;

    /*** Mapping with Hibernate**/

    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;

//    @ManyToMany(mappedBy = "products")
//    @JoinTable(name = "product_id")
//    private Set<Order> orders;


}
