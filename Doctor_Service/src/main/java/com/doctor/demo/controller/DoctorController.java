package com.doctor.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.doctor.demo.VO.ResponseTemplateVO;
import com.doctor.demo.entity.Doctor;
import com.doctor.demo.services.DoctorServices;

@RestController
public class DoctorController {
	@Autowired
	private DoctorServices doctorService;

	//Get all doctors
	@GetMapping("/doctors")
	public ResponseEntity<Object> getDoctors() {
		
		List<Doctor> list =doctorService.getAllDoctors();
		if(list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}
	
	//Get all doctors by id
	@GetMapping("/doctors/{id}")
	public ResponseEntity<Object> getDoctorbyId(@PathVariable("id")int id) {
		
		Doctor doctor = doctorService.getDoctorById(id);
		if(doctor == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(doctor));
	}
		
	//add doctors
	@PostMapping("/doctors")
	public ResponseEntity<Object> addDoctor(@RequestBody Doctor doctor) {
		Doctor doc=null;
		try {
			doc = this.doctorService.addDoctor(doctor);
			System.out.println(doc);
			return ResponseEntity.ok(Optional.of(doctor));
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	//delete Doctors
	@DeleteMapping("/doctors/{id}")
	public ResponseEntity<Void> deleteDoctor(@PathVariable("id")int id) {
		try{
			this.doctorService.deleteDoctor(id);
			return ResponseEntity.ok().build();
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	//Update doctors
	@PutMapping("/doctors/{id}")
	public ResponseEntity<Object> updateDoctor(@RequestBody Doctor doctor,@PathVariable("id")int id) {
		try{
			this.doctorService.updateDoctor(doctor, id);
			return ResponseEntity.ok().body(doctor);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	/********************/
	//Get appointment by doc Id
	@GetMapping("/doctors/appointment/{id}")
	public ResponseEntity<Object> getAppointment(@PathVariable("id")int id){
		ResponseTemplateVO apt = this.doctorService.getAppointment(id);
		if(apt == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.status(HttpStatus.FOUND).body(apt);
	}	
}
