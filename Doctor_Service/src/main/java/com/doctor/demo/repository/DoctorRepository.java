package com.doctor.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doctor.demo.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

}
