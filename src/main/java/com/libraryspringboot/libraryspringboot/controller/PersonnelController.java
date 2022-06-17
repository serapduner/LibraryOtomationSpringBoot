package com.libraryspringboot.libraryspringboot.controller;

import com.libraryspringboot.libraryspringboot.model.Personnel;
import com.libraryspringboot.libraryspringboot.service.PersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Set;

@Controller
public class PersonnelController {

    @Autowired
    private PersonnelService personnelService;




    @GetMapping("/showPersonnelList")
    public String showPersonnelList(Model model){
        model.addAttribute("listPersonnel", personnelService.getAllPersonnel());
        return "personnel_list";
    }
    @GetMapping("/showCheckboxPersonnelList")
    public String showCheckPersonnelList(Model model){
        Model listCheckPersonnel = model.addAllAttributes(Set.of("listCheckPersonnel", personnelService.getAllPersonnel()));
        return "new_borrow";
    }
    @GetMapping("/showNewPersonnelForm")
    public String showNewPersonnelForm(Model model) {
        // create model attribute to bind form data
        Personnel personnel = new Personnel();
        model.addAttribute("personnel", personnel);
        return "new_personnel";
    }

    @PostMapping("/savePersonnel")
    public String savePersonnel(@ModelAttribute("personnel") Personnel personnel) {
        // save personnel to database
        personnelService.savePersonnel(personnel);
        return "personnel_list";
    }

    @GetMapping("/showFormForUpdateP/{id}")
    public String showFormForUpdateP(@PathVariable(value = "id") long id, Model model) {

        // get personnel from the service
        Personnel personnel = personnelService.getPersonnelById(id);

        // set personnel as a model attribute to pre-populate the form
        model.addAttribute("personnel", personnel);
        return "update_personnel";
    }

    @GetMapping("/deletePersonnel/{id}")
    public String deletePersonnel(@PathVariable(value = "id") long id) {

        // call delete personnel method
        this.personnelService.deletePersonnelById(id);
        return "redirect:/";
    }

}