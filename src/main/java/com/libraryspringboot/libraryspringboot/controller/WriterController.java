package com.libraryspringboot.libraryspringboot.controller;

import com.libraryspringboot.libraryspringboot.model.Writer;
import com.libraryspringboot.libraryspringboot.service.WriterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class WriterController {
    @Autowired
    private  WriterService writerService;


    @GetMapping("/showWriterList")
    public String showWriterList(Model model) {
        model.addAttribute("listWriter", writerService.getAllWriters());
        return "writer_list";
    }

    @GetMapping("/showNewWriterForm")
    public String showNewWriterForm(Model model) {
        Writer writer=new Writer();
        model.addAttribute("writer", writer);
        return "new_writer";
    }

    @PostMapping("/saveWriter")
    public String saveWriter(@ModelAttribute("writer") Writer writer) {
        // save writer to database
        writerService.saveWriter(writer);
        return "writer_list";
    }


    @GetMapping("/showFormForUpdateC/{id}")
    public String showFormForUpdateC(@PathVariable(value = "id") long id, Model model) {

        // get writer from the service
        Writer writer = writerService.getWriterById(id);


        // set writer as a model attribute to pre-populate the form
        model.addAttribute("writer", writer);
        return "update_writer";
    }


    @GetMapping("/deleteWriter/{id}")
    public String deleteWriter(@PathVariable(value = "id") long id) {

        // call delete writer method
        this.writerService.deleteWriterById(id);
        return "writer_list";
    }

}