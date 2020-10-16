package com.urunov.rest.controller;

import com.urunov.rest.model.Category;
import com.urunov.rest.serviceRun.CategoryServiceRun;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CategoryController {


    private CategoryServiceRun categoryServiceRun;

    @GetMapping()
    public List<Category> getAllCategory(){
        return categoryServiceRun.allCategory();
    }

}
