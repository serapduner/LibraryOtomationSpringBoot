package com.libraryspringboot.libraryspringboot.controller;

import com.libraryspringboot.libraryspringboot.model.BookCategory;
import com.libraryspringboot.libraryspringboot.service.BookCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class BookCategoryController {
    @Autowired
    private  BookCategoryService bookCategoryService;


    @GetMapping("/F")
    public String viewHomePage(Model model) {
        model.addAttribute("listBookCategorys", bookCategoryService.getAllBookCategories());
        return "index";
    }

    @GetMapping("/showNewBookCategoryForm")
    public String showNewBookCategoryForm(Model model) {
        BookCategory bookCategory=new BookCategory();
        model.addAttribute("bookCategory", bookCategory);
        return "new_bookCategory";
    }

    @PostMapping("/saveBookCategory")
    public String saveBookCategory(@ModelAttribute("bookCategory") BookCategory bookCategory) {
        // save bookCategory to database
        bookCategoryService.saveBookCategory(bookCategory);
        return "redirect:/";
    }


    @GetMapping("/showFormForUpdateF/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get bookCategory from the service
        BookCategory bookCategory = bookCategoryService.getBookCategoryById(id);


        // set bookCategory as a model attribute to pre-populate the form
        model.addAttribute("bookCategory", bookCategory);
        return "update_bookCategory";
    }


    @GetMapping("/deleteBookCategory/{id}")
    public String deleteBookCategory(@PathVariable(value = "id") long id) {

        // call delete bookCategory method
        this.bookCategoryService.deleteBookCategoryById(id);
        return "redirect:/";
    }

}