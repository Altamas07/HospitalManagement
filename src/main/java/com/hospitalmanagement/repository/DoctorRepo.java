package com.hospitalmanagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospitalmanagement.entity.Doctor;
import java.util.List;


public interface DoctorRepo extends JpaRepository<Doctor, Long>{

	Optional<Doctor>  findByEmail(String email);
}
