package com.libraryspringboot.libraryspringboot.service;

import com.libraryspringboot.libraryspringboot.model.Book;

import java.util.List;

public interface BookService {
    List <Book> getAllBooks();
    Book saveBook(Book book);

    Book add(Book book);

    Book getBookById(long id);
    void deleteBookById(long id);


}
