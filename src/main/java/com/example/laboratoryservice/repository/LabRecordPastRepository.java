package com.example.laboratoryservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.laboratoryservice.model.LabRecordPast;

public interface LabRecordPastRepository extends JpaRepository<LabRecordPast, String> {

}
