package com.urunov.rest.repository;

import com.urunov.rest.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductResource extends JpaRepository<Product, Long > {

}
