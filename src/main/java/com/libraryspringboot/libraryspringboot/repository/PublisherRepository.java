package com.libraryspringboot.libraryspringboot.repository;

import com.libraryspringboot.libraryspringboot.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
