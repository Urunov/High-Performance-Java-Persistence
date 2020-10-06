package com.urunov.dataresource;

import com.urunov.input.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryResource extends JpaRepository<Category, Long> {
}
