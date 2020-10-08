package com.urunov.dataresource;

import com.urunov.input.info.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactResource extends JpaRepository<Contact, Long> {
}
