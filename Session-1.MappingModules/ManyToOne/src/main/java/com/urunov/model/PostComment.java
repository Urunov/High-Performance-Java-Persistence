package com.urunov.model;

import javax.persistence.Id;

/**
 * @Author: apple
 * @created on 17/09/2020
 * @Project is MappingSimple
 */
public class PostComment {


    @Id
    private Long id;

    private String review;
}
