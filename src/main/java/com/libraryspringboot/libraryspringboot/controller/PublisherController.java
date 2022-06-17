package com.libraryspringboot.libraryspringboot.controller;

import com.libraryspringboot.libraryspringboot.model.Publisher;
import com.libraryspringboot.libraryspringboot.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class PublisherController {
    @Autowired
    private  PublisherService publisherService;


    @GetMapping("/showPublisherList")
    public String showPublisherList(Model model) {
        model.addAttribute("listPublisher", publisherService.getAllPublishers());
        return "publisher_list";
    }

    @GetMapping("/showNewPublisherForm")
    public String showNewPublisherForm(Model model) {
        Publisher publisher=new Publisher();
        model.addAttribute("publisher", publisher);
        return "new_publisher";
    }

    @PostMapping("/savePublisher")
    public String savePublisher(@ModelAttribute("publisher") Publisher publisher) {
        // save publisher to database
        publisherService.savePublisher(publisher);
        return "redirect:/";
    }


    @GetMapping("/showFormForUpdateD/{id}")
    public String showFormForUpdateD(@PathVariable(value = "id") long id, Model model) {

        // get publisher from the service
        Publisher publisher = publisherService.getPublisherById(id);


        // set publisher as a model attribute to pre-populate the form
        model.addAttribute("publisher", publisher);
        return "update_publisher";
    }


    @GetMapping("/deletePublisher/{id}")
    public String deletePublisher(@PathVariable(value = "id") long id) {

        // call delete publisher method
        this.publisherService.deletePublisherById(id);
        return "redirect:/";
    }

}