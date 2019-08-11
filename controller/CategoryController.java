package com.springLearn.springApp.controller;


import com.springLearn.springApp.model.Category;
import com.springLearn.springApp.db.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @PostMapping()
    public ResponseEntity add(@RequestBody Category category){
        Integer id = categoryService.add(category);
        if (id != null) {
            return new ResponseEntity<>(id, HttpStatus.CREATED);
        }
        return new ResponseEntity<>( null, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @GetMapping()
    public ResponseEntity getAll() {
        List<Category> categoryList = categoryService.getCategories();
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }
}
