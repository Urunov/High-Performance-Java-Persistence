package com.urunov.input.info;

import com.urunov.input.Customer;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Slf4j
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Card implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;
    private String title;

    private int lastFourDigit;

    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;

}
