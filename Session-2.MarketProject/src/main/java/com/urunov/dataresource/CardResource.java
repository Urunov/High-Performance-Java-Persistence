package com.urunov.dataresource;

import com.urunov.input.info.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardResource extends JpaRepository<Card, Long> {
}
