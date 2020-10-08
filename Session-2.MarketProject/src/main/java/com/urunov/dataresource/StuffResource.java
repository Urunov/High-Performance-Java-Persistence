package com.urunov.dataresource;

import com.urunov.input.Stuff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StuffResource extends JpaRepository<Stuff, Long> {
}
