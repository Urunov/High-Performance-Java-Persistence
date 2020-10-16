package com.urunov.rest.repository;

import com.urunov.rest.model.info.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactResource extends JpaRepository<Contact, Long> {
}
