package com.urunov.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * @Author: apple
 * @created on 21/09/2020
 * @Project is AlternaviteShow
 */
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class PostTagId implements Serializable {
    
    private Long postId;
    
    private Long tagId;

    public PostTagId(Long postId, Long tagId) {
        this.postId = postId;
        this.tagId = tagId;
    }

    public PostTagId(Long postId) {
        this.postId = postId;
    }

    @Override
    public boolean equals(Object objects){
        if(this == objects) return true;

        if(objects == null || getClass()!=objects.getClass()) return false;

        PostTagId that = (PostTagId) objects;

        return Objects.equals(postId, that.postId) && Objects.equals(tagId, that.tagId);

    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, tagId);
    }
}
