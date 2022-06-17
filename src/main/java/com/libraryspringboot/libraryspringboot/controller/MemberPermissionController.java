package com.libraryspringboot.libraryspringboot.controller;

import com.libraryspringboot.libraryspringboot.model.MemberPermission;
import com.libraryspringboot.libraryspringboot.service.MemberPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class MemberPermissionController {

    @Autowired
    private MemberPermissionService memberPermissionService;


    // display list of memberPermissions


    @GetMapping("/showMemberPermissionList")
    public String showMemberPermissionList(Model model){
        model.addAttribute("listMemberPermissions", memberPermissionService.getALlMemberPermissions());
        return "memberPermission_list";
    }

    @GetMapping("/showNewMemberPermissionForm")
    public String showNewMemberPermissionForm(Model model) {
        // create model attribute to bind form data
        MemberPermission memberPermission = new MemberPermission();
        model.addAttribute("memberPermission", memberPermission);
        return "new_memberPermission";
    }

    @PostMapping("/saveMemberPermission")
    public String saveMemberPermission(@ModelAttribute("memberPermission") MemberPermission memberPermission) {
        // save memberPermission to database
        memberPermissionService.saveMemberPermission(memberPermission);
        return "memberPermission_list";
    }

    @GetMapping("/showFormForUpdateX/{id}")
    public String showFormForUpdateX(@PathVariable(value = "id") long id, Model model) {

        // get memberPermission from the service
        MemberPermission memberPermission = memberPermissionService.getMemberPermissionById(id);

        // set memberPermission as a model attribute to pre-populate the form
        model.addAttribute("memberPermission", memberPermission);
        return "update_memberPermission";
    }

    @GetMapping("/deleteMemberPermission/{id}")
    public String deleteMemberPermission(@PathVariable(value = "id") long id) {

        // call delete memberPermission method
        this.memberPermissionService.deleteMemberPermissionById(id);
        return "redirect:/";
    }

}