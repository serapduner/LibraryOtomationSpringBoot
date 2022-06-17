package com.libraryspringboot.libraryspringboot.controller;

import com.libraryspringboot.libraryspringboot.model.Borrow;
import com.libraryspringboot.libraryspringboot.service.BookService;
import com.libraryspringboot.libraryspringboot.service.BorrowService;
import com.libraryspringboot.libraryspringboot.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@Controller
public class BorrowController {
    @Autowired
    private  BorrowService borrowService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private BookService bookService;

    @GetMapping("showBorrowList")
    public String showBorrowList(Model model){
        model.addAttribute("listBorrow", borrowService.getAllBorrows());
        return "borrow_list";
    }



    @GetMapping("/showNewBorrowForm")
    public String showNewBorrowForm(Model model) {
        Borrow borrow=new Borrow();
        model.addAttribute("borrow", borrow);
        Model listCheckMembers = model.addAllAttributes(Set.of("listCheckMembers", memberService.getAllMembers()));
        /*Model listCheckBooks = model.addAllAttributes(Set.of("listCheckBooks", bookService.getAllBooks()));*/
        return "new_borrow";
    }

    @PostMapping("/saveBorrow")
    public String saveBorrow(@ModelAttribute("borrow") Borrow borrow) {
        // save borrow to database

        borrowService.saveBorrow(borrow);
        return "borrow_list";
    }


    @GetMapping("/showFormForUpdateB/{id}")
    public String showFormForUpdateB(@PathVariable(value = "id") long id, Model model) {

        // get borrow from the service
        Borrow borrow = borrowService.getBorrowById(id);


        // set borrow as a model attribute to pre-populate the form
        model.addAttribute("borrow", borrow);
        return "update_borrow";
    }


    @GetMapping("/deleteBorrow/{id}")
    public String deleteBorrow(@PathVariable(value = "id") long id) {

        // call delete borrow method
        this.borrowService.deleteBorrowById(id);
        return "redirect:/";
    }

}