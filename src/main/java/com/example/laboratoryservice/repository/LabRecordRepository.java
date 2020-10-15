package com.example.laboratoryservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.laboratoryservice.model.LabRecord;



public interface LabRecordRepository extends JpaRepository<LabRecord, String> {
	
	LabRecord findByTestId(String testId);
}
