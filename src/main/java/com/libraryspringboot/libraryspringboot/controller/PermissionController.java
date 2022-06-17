package com.libraryspringboot.libraryspringboot.controller;

import com.libraryspringboot.libraryspringboot.model.Permission;
import com.libraryspringboot.libraryspringboot.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Set;

@Controller
public class PermissionController {

    @Autowired
    private PermissionService permissionService;



    @GetMapping("/showPermissionList")
    public String showPermissionList(Model model){
        model.addAttribute("listPermissions", permissionService.getAllPermissions());
        return "permission_list";
    }
    @GetMapping("/showCheckboxPermissionList")
    public String showCheckPermissionList(Model model){
        Model listCheckPermissions = model.addAllAttributes(Set.of("listCheckPermissions", permissionService.getAllPermissions()));
        return "new_borrow";
    }
    @GetMapping("/showNewPermissionForm")
    public String showNewPermissionForm(Model model) {
        // create model attribute to bind form data
        Permission permission = new Permission();
        model.addAttribute("permission", permission);
        return "new_permission";
    }

    @PostMapping("/savePermission")
    public String savePermission(@ModelAttribute("permission") Permission permission) {
        // save permission to database
        permissionService.savePermission(permission);
        return "permission_list";
    }

    @GetMapping("/showFormForUpdateW/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get permission from the service
        Permission permission = permissionService.getPermissionById(id);

        // set permission as a model attribute to pre-populate the form
        model.addAttribute("permission", permission);
        return "update_permission";
    }

    @GetMapping("/deletePermission/{id}")
    public String deletePermission(@PathVariable(value = "id") long id) {

        // call delete permission method
        this.permissionService.deletePermissionById(id);
        return "redirect:/";
    }

}