package com.urunov.model;

import lombok.*;

import javax.persistence.*;
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
@ToString
@Entity
public class Post {

    @Id
    @Generated
    private Long id;

    private String title;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "post_tag", joinColumns = @JoinColumn(name = "post_id"),
                    inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tag> tags = new ArrayList<>();


    public Post(String s) {
        this.title = s;
    }


    public void addTag(Tag tag){
        tags.add(tag);

    }
}


