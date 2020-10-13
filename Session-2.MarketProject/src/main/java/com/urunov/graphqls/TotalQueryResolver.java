package com.urunov.graphqls;


import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.urunov.dataresource.CategoryResource;
import com.urunov.dataresource.ProductResource;
import com.urunov.input.Category;
import com.urunov.input.Product;
import lombok.RequiredArgsConstructor;

import java.util.List;

//@Component
@RequiredArgsConstructor
public class TotalQueryResolver implements GraphQLQueryResolver {

    private final CategoryResource categoryResource;
    private final ProductResource productResource;

   public Iterable<Category> allCategories(){
       return categoryResource.findAll();
   }

    public List<Product> findAllProducts(){
        return productResource.findAll();
    }

    public Category category(Long id){
       return categoryResource.findById(id).orElseThrow(null);
    }

    public long countProduct(){
        return productResource.count();
    }

    public Product findById(Long id){
        return productResource.findById(id).orElseThrow(null);
    }

}
