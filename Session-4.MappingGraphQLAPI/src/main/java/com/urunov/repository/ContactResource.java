package com.urunov.repository;

import com.urunov.entity.info.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactResource extends JpaRepository<Contact, Long> {
}
