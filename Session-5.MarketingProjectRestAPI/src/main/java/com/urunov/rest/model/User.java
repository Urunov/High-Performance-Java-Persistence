package com.urunov.rest.model;

import com.urunov.rest.model.info.Address;
import com.urunov.rest.model.info.Contact;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String image;
    private String email;

    private Date creation_date;

    @OneToMany(mappedBy = "user")
    private List<Address> address;

    @OneToMany(mappedBy = "user")
    private List<Contact> contacts;
}
