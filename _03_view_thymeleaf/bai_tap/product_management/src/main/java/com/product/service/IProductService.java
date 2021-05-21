package com.product.service;

import com.product.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IProductService {

    void create(Product product);
    List<Product> findAll();
    Product findId(int id);
    void delete(int id);

}
