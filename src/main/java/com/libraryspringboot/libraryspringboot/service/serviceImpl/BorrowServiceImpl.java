package com.libraryspringboot.libraryspringboot.service.serviceImpl;

import com.libraryspringboot.libraryspringboot.model.Borrow;
import com.libraryspringboot.libraryspringboot.repository.BorrowRepository;
import com.libraryspringboot.libraryspringboot.service.BorrowService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BorrowServiceImpl implements BorrowService {
    private final BorrowRepository borrowRepository;

    public BorrowServiceImpl(BorrowRepository borrowRepository) {this.borrowRepository = borrowRepository; }


    @Override
    public List<Borrow> getAllBorrows() {
        return borrowRepository.findAll();
    }

    @Override
    public Borrow saveBorrow(Borrow borrow) {
        this.borrowRepository.save(borrow);
        return borrow;
    }

    @Override
    public Borrow add(Borrow borrow) {
        this.borrowRepository.save(borrow);
        return borrow;
    }

    @Override
    public Borrow getBorrowById(long id) {
        Optional<Borrow>optional=borrowRepository.findById(id);
        Borrow borrow = null;
        if(optional.isPresent()){
            borrow=optional.get();
        }else{
            throw new RuntimeException("borrow not found for id:: " +id);
        }
        return borrow;
    }

    @Override
    public void deleteBorrowById(long id) {

        this.borrowRepository.deleteById(id);
    }
}
