package com.hospitalmanagement.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospitalmanagement.dto.PatientDto;
import com.hospitalmanagement.service.PatientService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientController {

	private final PatientService patientService;
	
	@PostMapping("/save")
	public PatientDto create(@Valid @RequestBody PatientDto patientDto) {
		
		PatientDto dto = patientService.create(patientDto);
		
		return dto;
	}
	@PutMapping("/update/{id}")
	public PatientDto update(@PathVariable("id")   Long id ,@RequestBody @Valid PatientDto patientDto) {
		PatientDto update = patientService.update(id, patientDto);
		return update;
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable("id") Long id) {
		
		patientService.delete(id);
	}
	@GetMapping("/getById/{id}")
	public PatientDto getById(@PathVariable("id") Long id) {
		
		PatientDto patientDto = patientService.getById(id);
		return patientDto;
	}
	@GetMapping
	public List<PatientDto> getAll() {
		List<PatientDto> list = patientService.getAll();
		return list;
	}
}
