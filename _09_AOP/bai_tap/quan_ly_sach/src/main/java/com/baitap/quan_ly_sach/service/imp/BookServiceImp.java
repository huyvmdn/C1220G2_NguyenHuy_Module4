package com.baitap.quan_ly_sach.service.imp;

import com.baitap.quan_ly_sach.Commons.ReadAndWrite;
import com.baitap.quan_ly_sach.entity.Book;
import com.baitap.quan_ly_sach.repository.BookRepository;
import com.baitap.quan_ly_sach.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class BookServiceImp implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }


}
