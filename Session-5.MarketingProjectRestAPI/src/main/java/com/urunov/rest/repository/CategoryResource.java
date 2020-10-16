package com.urunov.rest.repository;

import com.urunov.rest.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryResource extends JpaRepository<Category, Long> {
}
