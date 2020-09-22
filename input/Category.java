package com.urunov.input;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

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
public class Category implements Serializable {

    @Id
    private Long id;
    private String name;
    private String value;
    private String type;
    private String icon;
    private String slug;



}
