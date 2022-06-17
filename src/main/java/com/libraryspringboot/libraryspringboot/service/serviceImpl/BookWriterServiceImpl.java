package com.libraryspringboot.libraryspringboot.service.serviceImpl;

import com.libraryspringboot.libraryspringboot.model.BookWriter;
import com.libraryspringboot.libraryspringboot.repository.BookWriterRepository;
import com.libraryspringboot.libraryspringboot.service.BookWriterService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookWriterServiceImpl implements BookWriterService {
    private final BookWriterRepository bookWriterRepository;

    public BookWriterServiceImpl(BookWriterRepository bookWriterRepository) {
        this.bookWriterRepository = bookWriterRepository;
    }


    @Override
    public List<BookWriter> getAllBookWriters() {
        return bookWriterRepository.findAll();
    }

    @Override
    public BookWriter saveBookWriter(BookWriter bookWriter) {
        this.bookWriterRepository.save(bookWriter);
        return bookWriter;
    }

    @Override
    public BookWriter add(BookWriter bookWriter) {
        this.bookWriterRepository.save(bookWriter);
        return bookWriter;
    }

    @Override
    public BookWriter getBookWriterById(long id) {
        Optional< BookWriter > optional = bookWriterRepository.findById(id);
        BookWriter bookWriter = null;
        if (optional.isPresent()) {
            bookWriter = optional.get();
        } else {
            throw new RuntimeException(" bookWriter not found for id :: " + id);
        }
        return bookWriter;
    }

    @Override
    public void deleteBookWriterById(long id) {
        this.bookWriterRepository.deleteById(id);
    }
}
