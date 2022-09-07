package com.doctor.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.doctor.demo.VO.Appointment;
import com.doctor.demo.VO.ResponseTemplateVO;
import com.doctor.demo.entity.Doctor;
import com.doctor.demo.repository.DoctorRepository;

@Service
public class DoctorServices {

	@Autowired
	private DoctorRepository docRepo;
	@Autowired
	private RestTemplate restTemplate;
	//Get All Doctors
	public List<Doctor> getAllDoctors(){
		List<Doctor> doctors = (List<Doctor>)this.docRepo.findAll();
		return doctors;
	}
	
	//Get Doctor by id
	public Doctor getDoctorById(int id){
		Doctor doctor =null;
		try {
			doctor = this.docRepo.findById(id).get();
		}catch(Exception e) {
			System.out.print(e);	
		}
		System.out.print(doctor);
		return doctor;
	}
		
	//Adding doc
	public Doctor addDoctor(Doctor doctor) {
		Doctor result = docRepo.save(doctor);
		return result;
	}

	//Delete doc
	public void deleteDoctor(int id) {
		docRepo.deleteById(id);
	}

	//Update doc
	public Doctor updateDoctor(Doctor doctor, int id) {
		doctor.setId(id);
		docRepo.save(doctor);
		return doctor;
	}
	
	/********** Details of appointment ************/
	public ResponseTemplateVO getAppointment(int id) {
		ResponseTemplateVO vo = new ResponseTemplateVO();
		Doctor doctor = docRepo.findById(id).get();
		Appointment apt = restTemplate.getForObject("http://localhost:8082/appointments/"+doctor.getId(),
				Appointment.class);
		vo.setDoctor(doctor);
		vo.setApt(apt);
		return vo;
	}	
}
