package com.hospitalmanagement.service;

import java.util.List;

import com.hospitalmanagement.dto.DoctorDto;

public interface DoctorService {

	public DoctorDto create(DoctorDto doctorDto);
	public DoctorDto update(Long id, DoctorDto doctorDto);
	public void delete(Long id);
	public DoctorDto getById(Long id);
	public List<DoctorDto> getAll();
	
}
