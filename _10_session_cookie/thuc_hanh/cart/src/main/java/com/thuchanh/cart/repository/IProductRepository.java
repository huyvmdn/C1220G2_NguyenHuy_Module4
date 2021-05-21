package com.thuchanh.cart.repository;

import com.thuchanh.cart.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Long> {

}
