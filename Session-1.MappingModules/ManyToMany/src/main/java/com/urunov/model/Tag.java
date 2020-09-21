package com.urunov.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: apple
 * @created on 18/09/2020
 * @Project is ManyMapping
 */
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Tag {

    @Id
    @Generated
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "tags")
    private List<Post> postList = new ArrayList<>();


    public Tag(String java) {

        this.name = java;
    }
}