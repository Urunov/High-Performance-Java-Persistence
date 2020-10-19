package com.urunov.rest.service;

import com.urunov.rest.exceptions.ResourceNotFoundException;
import com.urunov.rest.model.Product;

import java.util.List;
import java.util.Map;
import java.util.Optional;


public interface ProductService {

   List<Product> AllProducts();
   Optional<Product> getProductById(Long productId) throws ResourceNotFoundException;
   void addProduct(Product product, long id);
   Product updateProduct(long id, Product productDetails) throws ResourceNotFoundException;

   Map<String, Boolean> deleteProductById(long id) throws ResourceNotFoundException;
}


