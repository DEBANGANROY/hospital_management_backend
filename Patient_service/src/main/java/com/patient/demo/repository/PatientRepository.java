package com.patient.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patient.demo.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer>{

}
