package com.urunov.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.urunov.entity.Category;
import com.urunov.entity.Product;
import com.urunov.repository.CategoryRepository;
import com.urunov.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: apple
 * @created on 29/08/2020
 * @Project is Crud
 */

@RequiredArgsConstructor
@Component
public class TotalQueryResolver implements GraphQLQueryResolver {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public Iterable<Category> allCategories(){
        return categoryRepository.findAll();
    }

    public List<Product>  allProducts(){
        return productRepository.findAll();
    }

    public Category category(Integer id){
        return categoryRepository.findById(id).orElseGet(null);
    }

    public Product product(Integer id){
        return productRepository.findById(id).orElseGet(null);
    }
}