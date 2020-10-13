package com.urunov.repository;

import com.urunov.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductResource extends JpaRepository<Product, Long > {
}
