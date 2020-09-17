package com.urunov.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: apple
 * @created on 13/09/2020
 * @Project is EssentialDB
 */

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Post {

    /**
     *  --------------------------
     *  | Parent Class is Post: |
     *  ------------------------
     *
     *  In a bidirectional association, only one side can control the underlying table relationship.
     *
     *  For the bidirectional @OneToMany mapping, it's the child-side @ManyToOne association in charge
     *  of keeping the foreign key column value in sync with the in-memory Persistence Context.
     *
     *  This is the reason why the bidirectional @OneToMany relationship must define the "mappedBy" attribute,
     *  indicating that it only mirrors the @ManyToOne child-side mapping.
     *
     *  an @OrderColumn annotation - must be defined along the @OneToMany relationship mapping:
     *
     * */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;




}
