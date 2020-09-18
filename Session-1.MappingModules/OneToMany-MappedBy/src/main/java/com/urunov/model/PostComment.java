package com.urunov.model;

import lombok.*;

import javax.persistence.*;

/**
 * @Author: apple
 * @created on 17/09/2020
 * @Project is MappedByMapping
 */

@Data
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "postcomment2")
public class PostComment {

    @Id
    @GeneratedValue
    private int id;

    private String review;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
}
