package com.urunov.repository;

import com.urunov.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: apple
 * @created on 29/08/2020
 * @Project is Crud
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
