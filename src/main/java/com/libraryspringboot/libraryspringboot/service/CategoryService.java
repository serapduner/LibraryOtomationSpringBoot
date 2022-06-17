package com.libraryspringboot.libraryspringboot.service;

import com.libraryspringboot.libraryspringboot.model.Category;

import java.util.List;

public interface CategoryService {
    List <Category> getAllCategories();
    Category saveCategory(Category category);

    Category add(Category category);

    Category getCategoryById(long id);
    void deleteCategoryById(long id);


}
