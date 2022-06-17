package com.libraryspringboot.libraryspringboot.service;

import com.libraryspringboot.libraryspringboot.model.Member;

import java.util.List;

public interface MemberService {
    List <Member> getAllMembers();
    Member saveMember(Member member);

    Member add(Member member);

    Member getMemberById(long id);
    void deleteMemberById(long id);


}
