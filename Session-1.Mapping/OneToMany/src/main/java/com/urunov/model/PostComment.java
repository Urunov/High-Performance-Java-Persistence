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
public class PostComment {

    @Id
    private Long id;

    private String review;

    /***
     * -----------------------------
     * | Child Class is PostComment |
     * ------------------------------
     *
     * Unidirectional [ @ManyToOne  ]
     *
     * Unfortunately, in spite its simplicity, the unidirectional @OneToMany association is less efficient than
     * the unidirectional @ManyToOne mapping or the bidirectional @OneToMany association.
     * */

       @ManyToOne  // not conditional also working well
       @JoinColumn(name = "post_id") // post_ id is foreign key
       private Post post;


}
