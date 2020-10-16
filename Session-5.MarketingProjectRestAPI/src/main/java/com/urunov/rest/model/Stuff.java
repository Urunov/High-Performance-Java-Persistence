package com.urunov.rest.model;


import com.urunov.rest.model.info.Address;
import com.urunov.rest.model.info.Contact;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Stuff implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    private String contactNumber;
    private String email;
    private String role;


    private Date creation_date;

    @OneToMany(mappedBy = "stuff")
    private List<Address> address = new ArrayList<>();

    @OneToMany(mappedBy = "stuff")
    private List<Contact> contacts = new ArrayList<>();
}
