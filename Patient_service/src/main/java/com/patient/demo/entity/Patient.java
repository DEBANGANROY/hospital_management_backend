package com.patient.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "patient")
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pat_id")
	private int id;
	@Column(name = "pat_name")
	private String name;
	@Column(name = "pat_contact")
	private long contact;
	@Column(name = "pat_problem")
	private String problem;
	
	public Patient() {
		super();
	}
	
	public Patient(int id, String name, long contact, String problem) {
		super();
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.problem = problem;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", contact=" + contact + ", problem=" + problem + "]";
	}	
}
