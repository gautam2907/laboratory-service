package com.example.laboratoryservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.laboratoryservice.model.TreatmentHistory;


public interface TreatmentHistoryRepository extends JpaRepository<TreatmentHistory, String>{

}
