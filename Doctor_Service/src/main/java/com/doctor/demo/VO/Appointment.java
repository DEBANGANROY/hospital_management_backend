package com.doctor.demo.VO;


public class Appointment {

	private int id;
	private String patientName;
	private String doctorName;
	private String date;
	public Appointment() {
		super();
	}
	public Appointment(int id, String patientName, String doctorName, String date) {
		super();
		this.id = id;
		this.patientName = patientName;
		this.doctorName = doctorName;
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
