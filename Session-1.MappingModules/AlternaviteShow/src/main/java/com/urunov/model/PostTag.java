package com.urunov.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

/**
 * @Author: apple
 * @created on 21/09/2020
 * @Project is AlternaviteShow
 */

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "post_tag")
public class PostTag {

    @EmbeddedId
    @Id
    private PostTagId id;

    @ManyToMany
    @MapsId("postId")
    private Post post;

    @ManyToOne
    @MapsId("tagsId")
    private Tag tag;


    public PostTag(Post post, Tag tag) {
        this.post = post;
        this.tag = tag;
    }



    @Override
    public int hashCode() {
        return Objects.hash(post, tag);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj ) return true;
        if(obj == null || getClass() !=obj.getClass()) return false;
        PostTag that  = (PostTag) obj;

        return Objects.equals(post, that.post) && Objects.equals(tag, that.tag);
    }
}
