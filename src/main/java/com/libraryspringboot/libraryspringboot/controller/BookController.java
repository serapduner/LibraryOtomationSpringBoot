package com.libraryspringboot.libraryspringboot.controller;

import com.libraryspringboot.libraryspringboot.model.Book;
import com.libraryspringboot.libraryspringboot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Set;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;


    // display list of books
    @GetMapping("/")
    public String viewHomePage(Model model) {

        return "index";
    }


    @GetMapping("/showBookList")
    public String showBookList(Model model){
        model.addAttribute("listBooks", bookService.getAllBooks());
        return "book_list";
    }
    @GetMapping("/showCheckboxBookList")
    public String showCheckBookList(Model model){
        Model listCheckBooks = model.addAllAttributes(Set.of("listCheckBooks", bookService.getAllBooks()));
        return "new_borrow";
    }
    @GetMapping("/showNewBookForm")
    public String showNewBookForm(Model model) {
        // create model attribute to bind form data
        Book book = new Book();
        model.addAttribute("book", book);
        return "new_book";
    }

    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute("book") Book book) {
        // save book to database
        bookService.saveBook(book);
        return "book_list";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get book from the service
        Book book = bookService.getBookById(id);

        // set book as a model attribute to pre-populate the form
        model.addAttribute("book", book);
        return "update_book";
    }

    @GetMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable(value = "id") long id) {

        // call delete book method
        this.bookService.deleteBookById(id);
        return "redirect:/";
    }

}