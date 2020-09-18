package com.urunov.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: apple
 * @created on 17/09/2020
 * @Project is MappedByMapping
 */
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "post2")
public class Post {

    /**
     *  --------------------------
     *  | Parent Class is Post: |
     *  ------------------------
     *

     * */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    /***
     * @OneToMany
     *
     * */

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "post")
    @OrderColumn(name = "entry")
    private List<PostComment> comments = new ArrayList<>();

}
