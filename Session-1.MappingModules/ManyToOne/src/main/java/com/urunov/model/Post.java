package com.urunov.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: apple
 * @created on 17/09/2020
 * @Project is MappingSimple
 */
@Data
@Getter
@Setter
@Entity

public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "post")
//    @OrderColumn(name = "entry")   /** adding column in the PostComment table. ***/
    private List<PostComment> comments = new ArrayList<>();
//

}
