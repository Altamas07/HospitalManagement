package com.hospitalmanagement.service;

import java.util.List;

import com.hospitalmanagement.dto.PatientDto;

public interface PatientService {

	public PatientDto create(PatientDto patientDto);
	public PatientDto update(Long id,PatientDto patientDto);
	public void delete(Long id);
	public PatientDto getById(Long id);
	public List<PatientDto> getAll();
}
