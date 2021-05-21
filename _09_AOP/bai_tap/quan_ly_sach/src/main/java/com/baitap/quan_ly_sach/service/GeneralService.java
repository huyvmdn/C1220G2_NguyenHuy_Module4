package com.baitap.quan_ly_sach.service;


import java.util.Optional;

public interface GeneralService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    void save(T t);

    void deleteById(Long id);

}
