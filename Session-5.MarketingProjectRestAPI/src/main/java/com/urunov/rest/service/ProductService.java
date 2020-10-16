package com.urunov.rest.service;

import com.urunov.rest.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

   List<ProductService> AllProducts();

   ProductService getProductById(Long productId);

   void addProduct(Product product);

   void deleteProductById(long id);

   void updateProduct(Product product);
}
