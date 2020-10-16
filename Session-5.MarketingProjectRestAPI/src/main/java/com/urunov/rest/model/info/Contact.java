package com.urunov.rest.model.info;

import com.urunov.rest.model.Customer;
import com.urunov.rest.model.Stuff;
import com.urunov.rest.model.User;
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
public class Contact implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private String number;

    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    private Stuff stuff;
}
