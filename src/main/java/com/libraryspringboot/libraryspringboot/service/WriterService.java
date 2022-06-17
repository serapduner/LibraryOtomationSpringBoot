package com.libraryspringboot.libraryspringboot.service;

import com.libraryspringboot.libraryspringboot.model.Writer;

import java.util.List;

public interface WriterService {
    List<Writer> getAllWriters();
    Writer saveWriter(Writer writer);

    Writer add(Writer writer);

    Writer getWriterById(long id);
    void deleteWriterById(long id);
}
