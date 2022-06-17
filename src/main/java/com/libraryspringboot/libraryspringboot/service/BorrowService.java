package com.libraryspringboot.libraryspringboot.service;

import com.libraryspringboot.libraryspringboot.model.Borrow;

import java.util.List;

public interface BorrowService {
    List <Borrow> getAllBorrows();

    Borrow saveBorrow(Borrow borrow);

    Borrow add(Borrow borrow);

    Borrow getBorrowById(long id);

    void deleteBorrowById(long id);


}
