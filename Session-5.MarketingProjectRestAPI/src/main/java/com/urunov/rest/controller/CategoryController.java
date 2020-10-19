package com.urunov.rest.controller;

import com.urunov.rest.exceptions.ResourceNotFoundException;
import com.urunov.rest.model.Category;
import com.urunov.rest.serviceRun.CategoryServiceRun;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/product/")
public class CategoryController {


    private CategoryServiceRun categoryServiceRun;

    @GetMapping("/all")
    public List<Category> getAllCategory(){
        return categoryServiceRun.allCategory();
    }

    @GetMapping("/{id}")
    public ResponseEntity <Category> getCategoryId(@PathVariable (value = "id") Long categoryId) throws ResourceNotFoundException {
        Category category = categoryServiceRun.get(categoryId);

        return ResponseEntity.ok().body(category);
    }

    @PostMapping("/add/")
    public Optional<Category> addCategory(@Valid @RequestBody Category category, Long id){

        return categoryServiceRun.add(category, id);
    }

    @PutMapping("/{id}/")
    public ResponseEntity<Category> updateCategory(@PathVariable(value = "id") long id, @RequestBody Category categoryDetail) throws ResourceNotFoundException{
        Category updateCategory = categoryServiceRun.update(categoryDetail, id);
        return ResponseEntity.ok(updateCategory);
    }

    @DeleteMapping("/{id}/")
    public Map<String, Boolean> deleteCategory(@PathVariable (value = "id") Long id) throws ResourceNotFoundException{
        return categoryServiceRun.delete(id);
    }
}
