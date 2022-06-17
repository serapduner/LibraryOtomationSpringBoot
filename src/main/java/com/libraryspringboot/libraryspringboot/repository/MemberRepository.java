package com.libraryspringboot.libraryspringboot.repository;

import com.libraryspringboot.libraryspringboot.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {
}
