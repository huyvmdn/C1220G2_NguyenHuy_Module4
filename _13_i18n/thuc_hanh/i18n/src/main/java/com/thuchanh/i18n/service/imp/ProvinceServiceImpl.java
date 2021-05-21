package com.thuchanh.i18n.service.imp;
import com.thuchanh.i18n.entity.Province;
import com.thuchanh.i18n.repository.ProvinceRepository;
import com.thuchanh.i18n.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvinceService {

    @Autowired
    ProvinceRepository repository;

    @Override
    public List<Province> findAll() {
        return repository.findAll();
    }
}