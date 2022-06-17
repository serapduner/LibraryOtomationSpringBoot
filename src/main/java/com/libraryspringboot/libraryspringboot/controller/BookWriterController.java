package com.libraryspringboot.libraryspringboot.controller;

import com.libraryspringboot.libraryspringboot.model.BookWriter;
import com.libraryspringboot.libraryspringboot.service.BookWriterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class BookWriterController {
    @Autowired
    private  BookWriterService bookWriterService;


    @GetMapping("/G")
    public String viewHomePage(Model model) {
        model.addAttribute("listBookWriters", bookWriterService.getAllBookWriters());
        return "index";
    }

    @GetMapping("/showNewBookWriterForm")
    public String showNewBookWriterForm(Model model) {
        BookWriter bookWriter=new BookWriter();
        model.addAttribute("bookWriter", bookWriter);
        return "new_bookWriter";
    }

    @PostMapping("/saveBookWriter")
    public String saveBookWriter(@ModelAttribute("bookWriter") BookWriter bookWriter) {
        // save bookWriter to database
        bookWriterService.saveBookWriter(bookWriter);
        return "redirect:/";
    }


    @GetMapping("/showFormForUpdateG/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get bookWriter from the service
        BookWriter bookWriter = bookWriterService.getBookWriterById(id);


        // set bookWriter as a model attribute to pre-populate the form
        model.addAttribute("bookWriter", bookWriter);
        return "update_bookWriter";
    }


    @GetMapping("/deleteBookWriter/{id}")
    public String deleteBookWriter(@PathVariable(value = "id") long id) {

        // call delete bookWriter method
        this.bookWriterService.deleteBookWriterById(id);
        return "redirect:/";
    }

}