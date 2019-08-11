package com.springLearn.springApp.db.services.impl;

import com.springLearn.springApp.model.Category;
import com.springLearn.springApp.db.repository.CategoryRepository;
import com.springLearn.springApp.db.services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getCategories() {
        return categoryRepository.getAll();
    }

    @Override
    public Integer add(Category category) {
        return categoryRepository.add(category);
    }

}

