package com.example.laboratoryservice.model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="lab_test_records")
public class LabRecord {
	
	@Id
	@GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name="test_id")
	private String testId;
	@Column(name="treatment_id")
	private String treatmentId;
	@Column(name="test_name")
	private String testName;
	@Column(name="physician_id")
	private String physicianId;
	@Column(name="patient_id")
	private String patientId;
	private Date date;
	private Time time;
	
	
	public LabRecord() {
	}


	public LabRecord(String testId, String treatmentId, String testName, String physicianId, String patientId,
			 Date date, Time time) {
		super();
		this.testId = testId;
		this.treatmentId = treatmentId;
		this.testName = testName;
		this.physicianId = physicianId;
		this.patientId = patientId;
		this.date = date;
		this.time = time;
	}


	public String getTestId() {
		return testId;
	}


	public void setTestId(String testId) {
		this.testId = testId;
	}
	

	public String getTreatmentId() {
		return treatmentId;
	}


	public void setTreatmentId(String treatmentId) {
		this.treatmentId = treatmentId;
	}


	public String getTestName() {
		return testName;
	}


	public void setTestName(String testName) {
		this.testName = testName;
	}


	public String getPhysicianId() {
		return physicianId;
	}


	public void setPhysicianId(String physicianId) {
		this.physicianId = physicianId;
	}


	public String getPatientId() {
		return patientId;
	}


	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}



	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Time getTime() {
		return time;
	}


	public void setTime(Time time) {
		this.time = time;
	}
	
	
	
	
}
