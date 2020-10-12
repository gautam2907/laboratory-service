package com.example.laboratoryservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="treatment_history")
public class TreatmentHistory {
	
	@Id
	@GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name="treatment_id")
	private String treatmentId;
	@Column(name="patient_id")
	private String patientId;
	@Column(name="physician_id")
	private String physicianId;
	@Column(name="tests_prescribed")
	private String labTestsPrescribed;
	@Column(name="medicines_prescribed")
	private String medicinesPrescribed;
	private String prescription;
	
	TreatmentHistory(){
		
	}

	public TreatmentHistory(String treatmentId, String patientId, String physicianId, String labTestsPrescribed,
			String medicinesPrescribed, String prescription) {
		super();
		this.treatmentId = treatmentId;
		this.patientId = patientId;
		this.physicianId = physicianId;
		this.labTestsPrescribed = labTestsPrescribed;
		this.medicinesPrescribed = medicinesPrescribed;
		this.prescription = prescription;
	}

	public String getTreatmentId() {
		return treatmentId;
	}

	public void setTreatmentId(String treatmentId) {
		this.treatmentId = treatmentId;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getPhysicianId() {
		return physicianId;
	}

	public void setPhysicianId(String physicianId) {
		this.physicianId = physicianId;
	}

	public String getLabTestsPrescribed() {
		return labTestsPrescribed;
	}

	public void setLabTestsPrescribed(String labTestsPrescribed) {
		this.labTestsPrescribed = labTestsPrescribed;
	}

	public String getMedicinesPrescribed() {
		return medicinesPrescribed;
	}

	public void setMedicinesPrescribed(String medicinesPrescribed) {
		this.medicinesPrescribed = medicinesPrescribed;
	}

	public String getPrescription() {
		return prescription;
	}

	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}
	
	
	

}
