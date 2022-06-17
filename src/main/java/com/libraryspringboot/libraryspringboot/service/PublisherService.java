package com.libraryspringboot.libraryspringboot.service;

import com.libraryspringboot.libraryspringboot.model.Publisher;

import java.util.List;

public interface PublisherService {
    List<Publisher> getAllPublishers();
    Publisher savePublisher(Publisher Publisher);

    Publisher add(Publisher Publisher);

    Publisher getPublisherById(long id);
    void deletePublisherById(long id);

}
