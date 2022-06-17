package com.libraryspringboot.libraryspringboot.service;

import com.libraryspringboot.libraryspringboot.model.BookWriter;

import java.util.List;

public interface BookWriterService {
    List<BookWriter> getAllBookWriters();
    BookWriter saveBookWriter(BookWriter bookWriter);

    BookWriter add(BookWriter bookWriter);

    BookWriter getBookWriterById(long id);
    void deleteBookWriterById(long id);


}
