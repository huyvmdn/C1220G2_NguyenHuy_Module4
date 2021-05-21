package com.baitap.quan_ly_sach.service.imp;

import com.baitap.quan_ly_sach.entity.Book;
import com.baitap.quan_ly_sach.entity.RentalCode;
import com.baitap.quan_ly_sach.repository.BookRepository;
import com.baitap.quan_ly_sach.repository.RentalCodeRepository;
import com.baitap.quan_ly_sach.service.RentalCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class RentalServiceImp implements RentalCodeService {

    @Autowired
    private RentalCodeRepository rentalCodeRepository;
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Iterable<RentalCode> findAll() {
        return rentalCodeRepository.findAll();
    }

    @Override
    public Optional<RentalCode> findById(Long id) {
        return rentalCodeRepository.findById(id);
    }

    @Override
    public void save(RentalCode rentalCode) {
        rentalCodeRepository.save(rentalCode);
        rentalCode.getBook().setStock(rentalCode.getBook().getStock()-1);
        bookRepository.save(rentalCode.getBook());
    }

    @Override
    public void deleteById(Long id) {
        rentalCodeRepository.deleteById(id);
    }

    @Override
    public void deleteByCodeRentalCode(String rentalCode) {
        Book book= rentalCodeRepository.findFirstByCodeRentalCode(rentalCode).getBook();
        book.setStock(book.getStock()+1);
        bookRepository.save(book);
         rentalCodeRepository.delete(rentalCodeRepository.findFirstByCodeRentalCode(rentalCode));
    }
    public boolean findByCodeRentalCode(String rentalCode) {

        if ( rentalCodeRepository.findByCodeRentalCode(rentalCode) !=null) {
            return true;
        }
        return false;
    }
}
