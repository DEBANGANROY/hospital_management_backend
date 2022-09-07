package com.patient.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.patient.demo.entity.Patient;
import com.patient.demo.repository.PatientRepository;

@Component
public class PatientServices {

	@Autowired
	private PatientRepository patientRepo;

	//Get all Patients
	public List<Patient> getAllPatients() {
		List<Patient> patients = (List<Patient>)this.patientRepo.findAll();
		return patients;
	}
	
	//Get patients by Id
	public Patient getPatientsbyId(int id){
		Patient patient =null;
		try {
			patient = this.patientRepo.findById(id).get();
		}catch(Exception e) {
			System.out.print(e);	
		}
		return patient;
	}
	//Add Patients
	public Patient addPatient(Patient doctor) {
		Patient result = patientRepo.save(doctor);
		return result;
	}
	
}
