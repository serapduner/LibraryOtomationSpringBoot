package com.libraryspringboot.libraryspringboot.service.serviceImpl;

import com.libraryspringboot.libraryspringboot.model.Member;
import com.libraryspringboot.libraryspringboot.repository.MemberRepository;
import com.libraryspringboot.libraryspringboot.service.MemberService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Member saveMember(Member member){
        this.memberRepository.save(member);
        return member;
    }

    @Override
    public Member add(Member member) {

        this.memberRepository.save(member);
        return member;
    }


    @Override
    public Member getMemberById(long id) {
        Optional< Member > optional = memberRepository.findById(id);
        Member member = null;
        if (optional.isPresent()) {
            member = optional.get();
        } else {
            throw new RuntimeException(" member not found for id :: " + id);
        }
        return member;

    }

    @Override
    public void deleteMemberById(long id) {
        this.memberRepository.deleteById(id);
    }




}
