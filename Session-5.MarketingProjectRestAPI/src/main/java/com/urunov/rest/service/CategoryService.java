package com.urunov.rest.service;

import com.urunov.rest.exceptions.ResourceNotFoundException;
import com.urunov.rest.model.Category;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface CategoryService {

    Category get(long id);
    List<Category> allCategory();
    Optional<Category> add(Category category, long id);
    Category update(Category category, long id) throws ResourceNotFoundException;
    Map<String, Boolean> delete(long id) throws ResourceNotFoundException;
}
