package com.libraryspringboot.libraryspringboot.service.serviceImpl;

import com.libraryspringboot.libraryspringboot.model.Category;
import com.libraryspringboot.libraryspringboot.repository.CategoryRepository;
import com.libraryspringboot.libraryspringboot.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category saveCategory(Category category) {
        this.categoryRepository.save(category);
        return category;
    }

    @Override
    public Category add(Category category) {
        this.categoryRepository.save(category);
        return category;
    }

    @Override
    public Category getCategoryById(long id) {
        Optional< Category > optional = categoryRepository.findById(id);
        Category category = null;
        if (optional.isPresent()) {
            category = optional.get();
        } else {
            throw new RuntimeException(" category not found for id :: " + id);
        }
        return category;
    }

    @Override
    public void deleteCategoryById(long id) {
        this.categoryRepository.deleteById(id);
    }
}
