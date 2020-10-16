package com.urunov.rest.repository;

import com.urunov.rest.model.info.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardResource extends JpaRepository<Card, Long> {
}
