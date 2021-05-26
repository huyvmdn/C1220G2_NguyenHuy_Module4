package com.testfinal.module4.service;


import com.testfinal.module4.model.security.Role;

import java.util.List;



public interface RoleService {
    Role findByName(String name);
    List<Role> findAll();
    Role findById(long id);
}
