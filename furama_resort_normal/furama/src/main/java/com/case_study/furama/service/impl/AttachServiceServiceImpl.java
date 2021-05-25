package com.case_study.furama.service.impl;


import com.case_study.furama.model.entity.AttachService;
import com.case_study.furama.repository.AttachServiceRepository;
import com.case_study.furama.service.AttachServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AttachServiceServiceImpl implements AttachServiceService {

    @Autowired
    private AttachServiceRepository attachServiceRepository;

    @Override
    public Iterable<AttachService> findAll() {
        return attachServiceRepository.findAll();
    }

    @Override
    public Page<AttachService> findAll(Pageable pageable) {
        return attachServiceRepository.findAll(pageable);
    }

    @Override
    public Optional<AttachService> findById(Long id) {
        return attachServiceRepository.findById(id);
    }

    @Override
    public AttachService save(AttachService attachService) {
        return attachServiceRepository.save(attachService);
    }

    @Override
    public void deleteById(Long idDelete) {
        attachServiceRepository.deleteById(idDelete);
    }
}
