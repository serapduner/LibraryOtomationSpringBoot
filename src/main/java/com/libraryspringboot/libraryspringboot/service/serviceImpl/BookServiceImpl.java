package com.libraryspringboot.libraryspringboot.service.serviceImpl;

import com.libraryspringboot.libraryspringboot.model.Book;
import com.libraryspringboot.libraryspringboot.repository.BookRepository;
import com.libraryspringboot.libraryspringboot.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book saveBook(Book book){
        this.bookRepository.save(book);
        return book;
    }

    @Override
    public Book add(Book book) {

        this.bookRepository.save(book);
        return book;
    }


    @Override
    public Book getBookById(long id) {
        Optional< Book > optional = bookRepository.findById(id);
        Book book = null;
        if (optional.isPresent()) {
            book = optional.get();
        } else {
            throw new RuntimeException(" book not found for id :: " + id);
        }
        return book;

    }

    @Override
    public void deleteBookById(long id) {
        this.bookRepository.deleteById(id);
    }




}
