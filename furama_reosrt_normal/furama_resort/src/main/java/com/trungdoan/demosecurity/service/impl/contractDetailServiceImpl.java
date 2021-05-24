package com.trungdoan.demosecurity.service.impl;

import com.trungdoan.demosecurity.model.entity.ContractDetail;
import com.trungdoan.demosecurity.repository.ContractDetailRepository;
import com.trungdoan.demosecurity.service.ContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class contractDetailServiceImpl implements ContractDetailService {

    @Autowired
    protected ContractDetailRepository contractDetailRepository;

    @Override
    public Iterable<ContractDetail> findAll() {
        return contractDetailRepository.findAll();
    }

    @Override
    public Page<ContractDetail> findAll(Pageable pageable) {
        return contractDetailRepository.findAll(pageable);
    }

    @Override
    public Optional<ContractDetail> findById(Long id) {
        return contractDetailRepository.findById(id);
    }

    @Override
    public ContractDetail save(ContractDetail contractDetail) {
        return contractDetailRepository.save(contractDetail);
    }

    @Override
    public void deleteById(Long idDelete) {
        contractDetailRepository.deleteById(idDelete);
    }


}
