package com.libraryspringboot.libraryspringboot.service;

import com.libraryspringboot.libraryspringboot.model.BookCategory;

import java.util.List;

public interface BookCategoryService {
    List <BookCategory> getAllBookCategories();
    BookCategory saveBookCategory(BookCategory bookCategory);

    BookCategory add(BookCategory bookCategory);

    BookCategory getBookCategoryById(long id);
    void deleteBookCategoryById(long id);


}
