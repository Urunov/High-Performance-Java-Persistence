package com.urunov.model;

import lombok.Data;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @Author: apple
 * @created on 18/09/2020
 * @Project is OneDirection
 */

@Data
@Getter
@Setter
@Entity
public class Post {

    @Id
    @Generated
    private Long id;

    private String title;

    @OneToOne(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private PostDetails details;
}
