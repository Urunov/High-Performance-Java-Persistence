package com.urunov.rest.controller;

import com.urunov.rest.model.Product;
import com.urunov.rest.repository.ProductResource;
import com.urunov.rest.service.ProductService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ProductController implements ProductService{

    private ProductResource productResource;
    private ProductService productService;


    @Override
    public List<ProductService> AllProducts() {
        return null;
    }

    @Override
    public ProductService getProductById(Long productId) {
        return null;
    }

    @Override
    public void addProduct(Product product) {

    }

    @Override
    public void deleteProductById(long id) {

    }

    @Override
    public void updateProduct(Product product) {

    }
}
