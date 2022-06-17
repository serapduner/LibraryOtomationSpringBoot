package com.libraryspringboot.libraryspringboot.service;

import com.libraryspringboot.libraryspringboot.model.Personnel;

import java.util.List;

public interface PersonnelService {
    List<Personnel> getAllPersonnel();

    Personnel savePersonnel(Personnel personnel);

    Personnel add(Personnel personnel);

    Personnel getPersonnelById(long id);

    void deletePersonnelById(long id);
}
