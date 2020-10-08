package com.urunov.graphqls.AdjustValues;


import lombok.*;

import javax.persistence.Column;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdjustProduct {

    private long product_id;
    @Column(name = "product_name")
    private String name;
    private String slug;
    private String image;
    private String type;
    private String unit;
    private String description;
    private int price;

    private float salePrice; // nullable=true
    private int disc_in_pros; // default =0
    private int per_unit;  // default =1
    private int quantity; //
}

