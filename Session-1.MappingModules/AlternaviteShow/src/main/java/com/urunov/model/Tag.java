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
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Tag {

    @Id
    @Generated
    private Long id;

    private String name;


}
