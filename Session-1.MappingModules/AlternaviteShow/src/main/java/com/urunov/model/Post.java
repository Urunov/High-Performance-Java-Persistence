package com.urunov.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: apple
 * @created on 21/09/2020
 * @Project is AlternaviteShow
 */
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Post {

    @Id
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<PostTag> tags = new ArrayList<>();
}
