package com.baitap.jpa.service;

import com.baitap.jpa.entity.Detail;
import com.baitap.jpa.repository.DetailRipository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DetailService implements GeneralService<Detail> {

    @Autowired
    private DetailRipository detailRipository;

    @Override
    public Iterable<Detail> findAll() {
        return detailRipository.findAll();
    }

    @Override
    public Optional<Detail> findById(Long id) {
        return detailRipository.findById(id);
    }

    @Override
    public void save(Detail detail) {
        detailRipository.save(detail);
    }

    @Override
    public void deleteById(Long id) {
        detailRipository.deleteById(id);
    }
}
