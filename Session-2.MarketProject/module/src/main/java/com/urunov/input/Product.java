package com.urunov.input;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @Author: apple
 * @created on 21/09/2020
 * @Project is Project
 */

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {


    @Id
    private Long id;

    private String ProductName;

    private String image;



}
