package com.patient.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patient.demo.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String>{

}
