package com.libraryspringboot.libraryspringboot.repository;

import com.libraryspringboot.libraryspringboot.model.BookWriter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookWriterRepository extends JpaRepository<BookWriter,Long> {
}
