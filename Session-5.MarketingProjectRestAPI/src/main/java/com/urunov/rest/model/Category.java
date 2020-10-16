package com.urunov.rest.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long category_id;

    private String name;
    private String value;
    private String type;
    private String icon;
    private String slug;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Collection<Product> products = new ArrayList<>();


}
