package com.springLearn.springApp.db.services;

import com.springLearn.springApp.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getCategories();

    Integer add(Category category);
}
