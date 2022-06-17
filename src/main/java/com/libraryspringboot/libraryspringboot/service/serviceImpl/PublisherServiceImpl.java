package com.libraryspringboot.libraryspringboot.service.serviceImpl;

import com.libraryspringboot.libraryspringboot.model.Publisher;
import com.libraryspringboot.libraryspringboot.repository.PublisherRepository;
import com.libraryspringboot.libraryspringboot.service.PublisherService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublisherServiceImpl implements PublisherService {
    private final PublisherRepository publisherRepository;

    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    @Override
    public Publisher savePublisher(Publisher publisher) {
        this.publisherRepository.save(publisher);
        return publisher;
    }

    @Override
    public Publisher add(Publisher publisher) {
        this.publisherRepository.save(publisher);
        return publisher;
    }

    @Override
    public Publisher getPublisherById(long id) {
        Optional< Publisher > optional = publisherRepository.findById(id);
        Publisher publisher = null;
        if (optional.isPresent()) {
            publisher = optional.get();
        } else {
            throw new RuntimeException(" publisher not found for id :: " + id);
        }
        return publisher;
    }

    @Override
    public void deletePublisherById(long id) {
        this.publisherRepository.deleteById(id);
    }
}
