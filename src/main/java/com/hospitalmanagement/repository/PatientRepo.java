package com.hospitalmanagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospitalmanagement.entity.Patient;

public interface PatientRepo extends JpaRepository<Patient, Long> {

	Optional<Patient> findByEmail(String email);
}
