package com.patient.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.patient.demo.entity.Patient;
import com.patient.demo.repository.PatientRepository;
import com.patient.demo.services.PatientServices;

@SpringBootTest(classes = { PatientServiceTest.class })
@TestMethodOrder(OrderAnnotation.class)
public class PatientServiceTest {

	@Mock
	private PatientRepository docRepo;
	@InjectMocks
	private PatientServices docService;

	public List<Patient> doctorList;

	// Get All Doctors Test
	@Test
	@Order(1)
	public void test_getAllDoctors() {
		List<Patient> doctorList = new ArrayList<>();
		doctorList.add(new Patient(1, "Ben",91919191, "Cold"));
		doctorList.add(new Patient(2, "Peter", 78787878, "Cough"));
		doctorList.add(new Patient(3, "Denver", 99999999, "Heart"));

		when(docRepo.findAll()).thenReturn(doctorList); // Mocking the dummy data
		assertEquals(doctorList.size(), docService.getAllPatients().size());
	}

	// Get Doctor by id Test
	@Test
	@Order(2)
	public void test_getDoctorById() {
		Optional<Patient> pat = Optional.of(new Patient(6, "Ram", 777777, "Nerve"));
		when(docRepo.findById(6)).thenReturn(pat);
		assertEquals(pat, Optional.of(docService.getPatientsbyId(6)));
	}
	
	@Test @Order(3)
	public void test_addDoctor() {
		Patient doc = new Patient(4, "Sam", 0000000, "Heat");
		when(docRepo.save(doc)).thenReturn(doc);
		assertEquals(doc,docService.addPatient(doc));
	}	
}
