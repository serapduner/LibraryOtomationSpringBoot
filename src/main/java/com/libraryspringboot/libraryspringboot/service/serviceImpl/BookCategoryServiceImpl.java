package com.libraryspringboot.libraryspringboot.service.serviceImpl;

import com.libraryspringboot.libraryspringboot.model.BookCategory;
import com.libraryspringboot.libraryspringboot.repository.BookCategoryRepository;
import com.libraryspringboot.libraryspringboot.service.BookCategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookCategoryServiceImpl implements BookCategoryService {
    private final BookCategoryRepository bookCategoryRepository;

    public BookCategoryServiceImpl(BookCategoryRepository bookCategoryRepository) {
        this.bookCategoryRepository = bookCategoryRepository;
    }

    @Override
    public List<BookCategory> getAllBookCategories() {
        return bookCategoryRepository.findAll();
    }

    @Override
    public BookCategory saveBookCategory(BookCategory bookCategory) {
        this.bookCategoryRepository.save(bookCategory);
        return bookCategory;
    }

    @Override
    public BookCategory add(BookCategory bookCategory) {
        this.bookCategoryRepository.save(bookCategory);
        return bookCategory;
    }

    @Override
    public BookCategory getBookCategoryById(long id) {
        Optional< BookCategory > optional = bookCategoryRepository.findById(id);
        BookCategory bookCategory = null;
        if (optional.isPresent()) {
            bookCategory = optional.get();
        } else {
            throw new RuntimeException(" bookCategory not found for id :: " + id);
        }
        return bookCategory;

    }

    @Override
    public void deleteBookCategoryById(long id) {
        this.bookCategoryRepository.deleteById(id);
    }
}
