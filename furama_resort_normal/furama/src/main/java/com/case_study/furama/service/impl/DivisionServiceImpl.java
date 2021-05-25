package com.case_study.furama.service.impl;

import com.case_study.furama.model.entity.Division;
import com.case_study.furama.repository.DivisionRepository;
import com.case_study.furama.service.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class DivisionServiceImpl implements DivisionService {

    @Autowired
    private DivisionRepository divisionRepository;

    @Override
    public Iterable<Division> findAll() {
        return divisionRepository.findAll();
    }

    @Override
    public Page<Division> findAll(Pageable pageable) {
        return divisionRepository.findAll(pageable);
    }

    @Override
    public Optional<Division> findById(Long id) {
        return divisionRepository.findById(id);
    }

    @Override
    public Division save(Division division) {
        return divisionRepository.save(division);
    }

    @Override
    public void deleteById(Long idDelete) {
        divisionRepository.deleteById(idDelete);
    }
}
