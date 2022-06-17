package com.libraryspringboot.libraryspringboot.service.serviceImpl;

import com.libraryspringboot.libraryspringboot.model.Writer;
import com.libraryspringboot.libraryspringboot.repository.WriterRepository;
import com.libraryspringboot.libraryspringboot.service.WriterService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WriterServiceImpl implements WriterService {

    private final WriterRepository writerRepository;

    public WriterServiceImpl(WriterRepository writerRepository) {
        this.writerRepository = writerRepository;
    }

    @Override
    public List<Writer> getAllWriters() {
        return writerRepository.findAll();
    }

    @Override
    public Writer saveWriter(Writer writer) {
        this.writerRepository.save(writer);
        return writer;
    }

    @Override
    public Writer add(Writer writer) {
        this.writerRepository.save(writer);
        return writer;
    }

    @Override
    public Writer getWriterById(long id) {
        Optional< Writer > optional = writerRepository.findById(id);
        Writer writer = null;
        if (optional.isPresent()) {
            writer = optional.get();
        } else {
            throw new RuntimeException(" writer not found for id :: " + id);
        }
        return writer;
    }

    @Override
    public void deleteWriterById(long id) {
        this.writerRepository.deleteById(id);
    }
}
