package com.patient.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.patient.demo.entity.Patient;
import com.patient.demo.services.PatientServices;

@RestController
public class PatientController {

	@Autowired
	private PatientServices patientService;
	
	//get patient
	@GetMapping("/patients")
	public ResponseEntity<List<Patient>> getPatients(){
		List<Patient> list =patientService.getAllPatients();
		if(list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}
	
	// get patient by id
	@GetMapping("/patients/{id}")
	public ResponseEntity<Object> getPatientbyId(@PathVariable("id")int id) {
		
		Patient patient = patientService.getPatientsbyId(id);
		if(patient == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(patient));
	}
	
	// add new patient
	@PostMapping("/patients")
	public ResponseEntity<Object> addPatient(@RequestBody Patient patient) {
		Patient pat =null;
		try {
			pat = this.patientService.addPatient(patient);
			System.out.println(pat);
			return ResponseEntity.ok(Optional.of(patient));
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
