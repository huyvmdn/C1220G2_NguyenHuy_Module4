package com.baitap.quan_ly_sach.repository;


import com.baitap.quan_ly_sach.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository  extends JpaRepository<Book,Long> {

}
