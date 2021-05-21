package com.baitap.jpa.service;

import com.baitap.jpa.entity.Cart;
import com.baitap.jpa.entity.Product;
import com.baitap.jpa.repository.CartRipository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService implements GeneralService<Cart>{

    @Autowired
    private CartRipository cartRipository;

    @Override
    public Iterable<Cart> findAll() {
        return cartRipository.findAll();
    }

    public Page<Cart> findAll(Pageable pageable) {
        return cartRipository.findAll(pageable);
    }


    @Override
    public Optional<Cart> findById(Long id) {
        return cartRipository.findById(id);
    }

    @Override
    public void save(Cart cart) {
        cartRipository.save(cart);
    }

    @Override
    public void deleteById(Long id) {
        cartRipository.deleteById(id);
    }

    public Page<Cart> searchFull(String name, String price, String date1, String date2, Pageable pageable) {
        return cartRipository.searchFull(name, price, date1, date2,pageable);
    }

    public Page<Cart> seach(String name, String price ,Pageable pageable) {
        return cartRipository.search(name,price,pageable);
    }
}
