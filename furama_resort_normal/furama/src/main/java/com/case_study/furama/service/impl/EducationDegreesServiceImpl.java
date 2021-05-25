package com.case_study.furama.service.impl;


import com.case_study.furama.model.entity.EducationDegree;
import com.case_study.furama.repository.EducationDegreeRepository;
import com.case_study.furama.service.EducationDegreesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class EducationDegreesServiceImpl implements EducationDegreesService {

    @Autowired
    private EducationDegreeRepository educationDegreeRepository;

    @Override
    public Iterable<EducationDegree> findAll() {
        return educationDegreeRepository.findAll();
    }

    @Override
    public Page<EducationDegree> findAll(Pageable pageable) {
        return educationDegreeRepository.findAll(pageable);
    }

    @Override
    public Optional<EducationDegree> findById(Long id) {
        return educationDegreeRepository.findById(id);
    }

    @Override
    public EducationDegree save(EducationDegree educationDegree) {
        return educationDegreeRepository.save(educationDegree);
    }

    @Override
    public void deleteById(Long idDelete) {
        educationDegreeRepository.deleteById(idDelete);
    }
}
