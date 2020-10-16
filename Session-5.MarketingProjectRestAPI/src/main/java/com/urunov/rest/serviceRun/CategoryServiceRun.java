package com.urunov.rest.serviceRun;

import com.urunov.rest.exceptions.ResourceNotFoundException;
import com.urunov.rest.model.Category;
import com.urunov.rest.repository.CategoryResource;
import com.urunov.rest.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CategoryServiceRun implements CategoryService {


    @Autowired
    private CategoryResource categoryResource;


    @Override
    public Category get(long id) {


        Optional<Category> optionalCategory = categoryResource.findById(id);
        Category category = null;

        if(optionalCategory.isPresent()){
            category = optionalCategory.get();
        }else{
            throw new RuntimeException("Category not found, this id: " + id);
        }

        return category;
    }

    @Override
    public List<Category> allCategory() {

        return categoryResource.findAll();
    }

    @Override
    public void add(Category category, long id) {

        Optional<Category> optionalCategory = categoryResource.findById(id);

        if(optionalCategory.isPresent()){
            throw new RuntimeException("Category already in the Database: " + id);
        }else{
            this.categoryResource.save(category);
        }
    }

    @Override
    public Category update(Category category, long id) throws ResourceNotFoundException {

        Category category1 = categoryResource.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Category would not find, id::"));

        category1.setName(category.getName());
        category1.setIcon(category.getIcon());
        category1.setSlug(category.getSlug());
        category1.setType(category.getType());
        category1.setValue(category.getValue());

        final Category update = categoryResource.save(category1);
        return update;

    }



    @Override
    public void delete(long id) {
        this.categoryResource.deleteById(id);
    }

}
