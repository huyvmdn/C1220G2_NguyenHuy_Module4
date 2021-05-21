package com.baitap.jpa.service;

import com.baitap.jpa.entity.Product;
import com.baitap.jpa.repository.ProductRipository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductService implements GeneralService<Product> {

    @Autowired
    private ProductRipository productRipository;
    @Override
    public Iterable<Product> findAll() {
        return productRipository.findAll();
    }

    public Page<Product> findAll(Pageable pageable) {
        return productRipository.findAll(pageable);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRipository.findById(id);
    }

    @Override
    public void save(Product product) {
    productRipository.save((product));
    }

    @Override
    public void deleteById(Long id) {
productRipository.deleteById(id);
    }

    public Page<Product> seach(String name, String price ,Pageable pageable) {
        return productRipository.search(name,price,pageable);
    }

    public Page<Product> searchFull(String name, String price, String date1, String date2,Pageable pageable) {
        return productRipository.searchFull(name, price, date1, date2,pageable);
    }
}
