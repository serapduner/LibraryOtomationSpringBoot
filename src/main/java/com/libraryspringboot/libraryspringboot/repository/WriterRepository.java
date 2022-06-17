package com.libraryspringboot.libraryspringboot.repository;

import com.libraryspringboot.libraryspringboot.model.Writer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WriterRepository extends JpaRepository<Writer, Long> {
}
