package com.libraryspringboot.libraryspringboot.service.serviceImpl;

import com.libraryspringboot.libraryspringboot.model.Book;
import com.libraryspringboot.libraryspringboot.model.Personnel;
import com.libraryspringboot.libraryspringboot.repository.PersonnelRepository;
import com.libraryspringboot.libraryspringboot.service.PersonnelService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonnelServiceImpl implements PersonnelService {
    private final PersonnelRepository personnelRepository;

    public PersonnelServiceImpl(PersonnelRepository personnelRepository) {
        this.personnelRepository = personnelRepository;
    }

    @Override
    public List<Personnel> getAllPersonnel() {return personnelRepository.findAll(); }

    @Override
    public Personnel savePersonnel(Personnel personnel) {
        this.personnelRepository.save(personnel);
        return personnel;
    }

    @Override
    public Personnel add(Personnel personnel) {
        this.personnelRepository.save(personnel);
        return personnel;
    }

    @Override
    public Personnel getPersonnelById(long id) {
        Optional<Personnel> optional = personnelRepository.findById(id);
        Personnel personnel = null;
        if (optional.isPresent()) {
            personnel = optional.get();
        } else {
            throw new RuntimeException(" personnel not found for id :: " + id);
        }
        return personnel;
    }

    @Override
    public void deletePersonnelById(long id) {
        this.personnelRepository.deleteById(id);

    }
}
