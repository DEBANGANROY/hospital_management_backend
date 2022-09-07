package com.doctor.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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

import com.doctor.demo.entity.Doctor;
import com.doctor.demo.repository.DoctorRepository;
import com.doctor.demo.services.DoctorServices;

@SpringBootTest(classes = { DoctorServiceMockitoTest.class })
@TestMethodOrder(OrderAnnotation.class)
public class DoctorServiceMockitoTest {

	@Mock
	private DoctorRepository docRepo;
	@InjectMocks
	private DoctorServices docService;

	public List<Doctor> doctorList;

	// Get All Doctors Test
	@Test
	@Order(1)
	public void test_getAllDoctors() {
		List<Doctor> doctorList = new ArrayList<>();
		doctorList.add(new Doctor(1, "Dr.Deshmukh", "ENT"));
		doctorList.add(new Doctor(2, "Dr.Pandey", "Eye"));
		doctorList.add(new Doctor(3, "Dr.Ghosh", "Cardio"));

		when(docRepo.findAll()).thenReturn(doctorList); // Mocking the dummy data
		assertEquals(doctorList.size(), docService.getAllDoctors().size());
	}

	// Get Doctor by id Test
	@Test
	@Order(2)
	public void test_getDoctorById() {
		Optional<Doctor> myDoctor = Optional.of(new Doctor(6, "Dr Rama", "Neurologist"));
		when(docRepo.findById(6)).thenReturn(myDoctor);
		assertEquals(myDoctor, Optional.of(docService.getDoctorById(6)));
	}
	
	@Test @Order(3)
	public void test_addDoctor() {
		Doctor doc = new Doctor(4, "DR. R.Sen", "Pediatrition");
		when(docRepo.save(doc)).thenReturn(doc);
		assertEquals(doc,docService.addDoctor(doc));
	}

	@Test @Order(4)
	public void test_deleteDoctor() {
		docService.deleteDoctor(3);
		assertNull(docService.getDoctorById(3));
	}
	
	@Test @Order(5)
	public void test_updateDoctor() {
		Doctor doc = new Doctor(4, "Dr. R.Sen", "Pediatrition");
		when(docRepo.save(doc)).thenReturn(doc);
		assertEquals(doc,docService.updateDoctor(doc, 4));
	}
	
	
}
