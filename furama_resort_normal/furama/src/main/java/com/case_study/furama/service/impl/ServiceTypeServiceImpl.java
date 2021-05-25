package com.case_study.furama.service.impl;


import com.case_study.furama.model.entity.ServiceType;
import com.case_study.furama.repository.ServiceTypeRepository;
import com.case_study.furama.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceTypeServiceImpl implements ServiceTypeService {

    @Autowired
    ServiceTypeRepository serviceTypeRepository;

    @Override
    public Iterable<ServiceType> findAll() {
        return serviceTypeRepository.findAll();
    }

    @Override
    public Page<ServiceType> findAll(Pageable pageable) {
        return serviceTypeRepository.findAll(pageable);
    }

    @Override
    public Optional<ServiceType> findById(Long id) {
        return serviceTypeRepository.findById(id);
    }

    @Override
    public ServiceType save(ServiceType serviceType) {
        return serviceTypeRepository.save(serviceType);
    }

    @Override
    public void deleteById(Long idDelete) {
    serviceTypeRepository.deleteById(idDelete);
    }
}
