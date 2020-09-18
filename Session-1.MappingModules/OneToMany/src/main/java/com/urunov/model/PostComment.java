package com.urunov.model;

import lombok.*;

import javax.persistence.*;

/**
 * @Author: apple
 * @created on 13/09/2020
 * @Project is EssentialDB
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
    private Long id;

    private String review;

    /***
     * -----------------------------
     * | Child Class is PostComment |
     * ------------------------------
     *
     * */


}
