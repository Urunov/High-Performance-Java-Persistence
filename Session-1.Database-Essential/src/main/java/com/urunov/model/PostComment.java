package com.urunov.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @Author: apple
 * @created on 13/09/2020
 * @Project is EssentialDB
 */

@Data
@Getter
@Setter
@Entity
public class PostComment {

    @Id
    private Long id;

    private String review;

    private Post post;
}
