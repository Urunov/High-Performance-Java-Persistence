package com.urunov.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Date;

/**
 * @Author: apple
 * @created on 18/09/2020
 * @Project is OneDirection
 */
@Data
@Getter
@Setter
@Entity
public class PostDetails {

    @Id
    private Long id;

    private Date createOn;

    private String createdBy;

    @OneToOne
    @JoinColumn(name = "post_id")
    private Post post;

}
