package com.libraryspringboot.libraryspringboot.controller;

import com.libraryspringboot.libraryspringboot.model.Member;
import com.libraryspringboot.libraryspringboot.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Set;


@Controller
public class MemberController {
    @Autowired
    private  MemberService memberService;


    @GetMapping("/showMemberList")
    public String showMemberList(Model model){
        model.addAttribute("listMembers", memberService.getAllMembers());
        return "member_list";
    }

    @GetMapping("/showCheckboxMemberList")
    public String showCheckMemberList(Model model){
        Model listCheckMembers = model.addAllAttributes(Set.of("listCheckMembers", memberService.getAllMembers()));
        return "new_borrow";
    }
    @GetMapping("/showNewMemberForm")
    public String showNewMemberForm(Model model) {
        Member member=new Member();
        model.addAttribute("member", member);
        return "new_member";
    }


    @PostMapping("/saveMember")
    public String saveMember(@ModelAttribute("member") Member member) {
        // save member to database
        memberService.saveMember(member);
        return "redirect:/";
    }


    @GetMapping("/showFormForUpdateA/{id}")
    public String showFormForUpdateA(@PathVariable(value = "id") long id, Model model) {

        // get member from the service
        Member member = memberService.getMemberById(id);


        // set member as a model attribute to pre-populate the form
        model.addAttribute("member", member);
        return "update_member";
    }


    @GetMapping("/deleteMember/{id}")
    public String deleteMember(@PathVariable(value = "id") long id) {

        // call delete member method
        this.memberService.deleteMemberById(id);
        return "redirect:/";
    }

}