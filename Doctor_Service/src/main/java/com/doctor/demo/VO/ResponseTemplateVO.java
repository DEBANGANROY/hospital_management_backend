package com.doctor.demo.VO;

import com.doctor.demo.entity.Doctor;

public class ResponseTemplateVO {

	private Doctor doctor;
	private Appointment apt;
	public ResponseTemplateVO() {
		super();
	}
	public ResponseTemplateVO(Doctor doctor, Appointment apt) {
		super();
		this.doctor = doctor;
		this.apt = apt;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public Appointment getApt() {
		return apt;
	}
	public void setApt(Appointment apt) {
		this.apt = apt;
	}
}
