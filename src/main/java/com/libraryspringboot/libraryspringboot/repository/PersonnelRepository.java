package com.libraryspringboot.libraryspringboot.repository;

import com.libraryspringboot.libraryspringboot.model.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonnelRepository extends JpaRepository<Personnel, Long> {
}
