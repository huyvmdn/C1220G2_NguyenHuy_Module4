package com.thuchanh.cart.repository.imp;
import com.thuchanh.cart.entity.Product;
import com.thuchanh.cart.repository.IProductRepository;
import com.thuchanh.cart.repository.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }
}