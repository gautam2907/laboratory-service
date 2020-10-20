package com.example.laboratoryservice.repository;

import com.example.laboratoryservice.model.ImageModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageRepository extends JpaRepository<ImageModel, String> {
    Optional<ImageModel> findByName(String name);

	Optional<ImageModel> findByTestId(String testId);
}
