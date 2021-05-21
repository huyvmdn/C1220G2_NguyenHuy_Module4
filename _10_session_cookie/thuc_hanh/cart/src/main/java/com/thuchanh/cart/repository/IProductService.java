package com.thuchanh.cart.repository;

import com.thuchanh.cart.entity.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();
    Optional<Product> findById(Long id);
}
