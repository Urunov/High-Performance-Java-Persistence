package com.urunov.rest.service;

import com.urunov.rest.exceptions.ResourceNotFoundException;
import com.urunov.rest.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

    Category get(long id);
    List<Category> allCategory();
    void add(Category category, long id);
    Category update(Category category, long id) throws ResourceNotFoundException;
    void delete(long id);
}
