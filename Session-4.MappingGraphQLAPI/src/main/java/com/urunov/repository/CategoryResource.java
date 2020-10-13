package com.urunov.repository;

import com.urunov.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryResource extends JpaRepository<Category, Long> {
}
