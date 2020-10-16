package com.urunov.rest.repository;

import com.urunov.rest.model.Stuff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StuffResource extends JpaRepository<Stuff, Long> {
}
