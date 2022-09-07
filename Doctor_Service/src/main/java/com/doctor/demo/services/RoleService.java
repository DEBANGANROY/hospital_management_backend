package com.doctor.demo.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctor.demo.entity.Role;
import com.doctor.demo.repository.RoleRepository;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleDao;

    public Role createNewRole(Role role) {
        return roleDao.save(role);
    }
}