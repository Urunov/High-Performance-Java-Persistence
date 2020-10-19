package com.urunov.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.urunov.entity.Category;
import com.urunov.entity.Product;
import com.urunov.repository.CategoryRepository;
import com.urunov.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @Author: apple
 * @created on 29/08/2020
 * @Project is Crud
 */
@Component
public class TotalMutationResolver implements GraphQLMutationResolver {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    public Category addCategory(String name) {

        Category category = new Category();
        category.setName(name);

        return categoryRepository.saveAndFlush(category);
    }

    public List<Category> allCategories(){

        return categoryRepository.findAll();
    }

    public Product addProduct(Long id, String name, String slug, String type, String unit, Float price, String code, Integer disc_in_pros, Integer per_unit, Integer quantity, String description, Date creation_date, Integer category_id) {

        Category category = categoryRepository.findById(category_id).orElseGet(null);

        Product product = new Product();

        product.setProduct_id(id);
        product.setName(name);
        product.setSlug(slug);
        product.setType(type);
        product.setUnit(unit);
        product.setPrice(price);
        product.setCode(code);
        product.setCategory(category);
        product.setDisc_in_pros(disc_in_pros);
        product.setPer_unit(per_unit);
        product.setQuantity(quantity);
        product.setDescription(description);
        product.setCreation_date(creation_date);

        return productRepository.saveAndFlush(product);
    }

    public Category updateCategory(Long id, String name){
        Category category = new Category();
        category.setCategory_id(id);
        category.setName(name);

        return categoryRepository.saveAndFlush(category);
    }

    public Product updateProduct(Long id, String name, String code, int price, Integer category_id){
        Category category = categoryRepository.findById(category_id).orElseGet(null);

        Product product = new Product();

        product.setProduct_id(id);
        product.setCode(code);
        product.setPrice(price);
        product.setCategory(category);

        return productRepository.saveAndFlush(product);
    }

    public Boolean deleteCategory(Integer id){
        categoryRepository.deleteById(id);
        return true;
    }

    public Boolean deleteProduct(Integer id){
       productRepository.deleteById(id);
        return true;
    }
}
