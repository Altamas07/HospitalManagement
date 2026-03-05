package com.hospitalmanagement.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hospitalmanagement.dto.PatientDto;
import com.hospitalmanagement.entity.Patient;
import com.hospitalmanagement.exception.ResourceNotFoundException;
import com.hospitalmanagement.mapper.PatientMapper;
import com.hospitalmanagement.repository.PatientRepo;
import com.hospitalmanagement.service.PatientService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

	private final PatientRepo patientRepo;
	
	@Override
	public PatientDto create(PatientDto patientDto) {
	
		Optional<Patient> existingPatient = patientRepo.findByEmail(patientDto.getEmail());
		if(existingPatient.isPresent()) {
			
			throw new ResourceNotFoundException("Patient already exist with same email id" +patientDto.getEmail());
		}
		
		Patient save = patientRepo.save(PatientMapper.dtoToEntity(patientDto));
		
		return PatientMapper.entityToDto(save);
	}

	@Override
	public PatientDto update(Long id, PatientDto patientDto) {
		Patient patient = patientRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Patient details not found "));
		if(!patient.getEmail().equals(patientDto.getEmail())) {
			patientRepo.findByEmail(patientDto.getEmail()).ifPresent(existing ->{ throw new ResourceNotFoundException("Patient email is already exist by another patient");
			});
		}
		patient.setBloodGroup(patientDto.getBloodGroup());
		patient.setCity(patientDto.getCity());
		patient.setDateOfBirth(patientDto.getDateOfBirth());
		patient.setEmail(patientDto.getEmail());
		patient.setFirstName(patientDto.getFirstName());
		patient.setGender(patientDto.getGender());
		patient.setLastName(patientDto.getLastName());
		patient.setMobileNumber(patientDto.getMobileNumber());
		patient.setPincode(patientDto.getPincode() );
		patient.setState(patientDto.getState());
		Patient patient2 = patientRepo.save(patient);
		return PatientMapper.entityToDto(patient2);
	}

	@Override
	public void delete(Long id) {
		
		Patient patient = patientRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Patient not found "));
		patientRepo.delete(patient);
		
	}

	@Override
	public PatientDto getById(Long id) {
		Patient patient = patientRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Cannot find patient with that id "));
		return PatientMapper.entityToDto(patient);
	}

	@Override
	public List<PatientDto> getAll() {
		
		List<Patient> list = patientRepo.findAll();
		
		
		return list.stream().map(PatientMapper::entityToDto).toList();
	}

}
