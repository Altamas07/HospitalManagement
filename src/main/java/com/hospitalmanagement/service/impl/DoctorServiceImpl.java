package com.hospitalmanagement.service.impl;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

import com.hospitalmanagement.dto.DoctorDto;
import com.hospitalmanagement.entity.Doctor;
import com.hospitalmanagement.exception.ResourceNotFoundException;
import com.hospitalmanagement.mapper.DoctorMapper;
import com.hospitalmanagement.repository.DoctorRepo;
import com.hospitalmanagement.service.DoctorService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

   

	private final DoctorRepo doctorRepo;

    
	@Override
	public DoctorDto create(DoctorDto doctorDto) {
	
		Optional<Doctor> doctor = doctorRepo.findByEmail(doctorDto.getEmail());
		
		if(doctor.isPresent()) {
			
			throw new ResourceNotFoundException("Doctor already exist ");
		}
		
		Doctor save = doctorRepo.save(DoctorMapper.dtoToEntity(doctorDto));
		
		return DoctorMapper.entityToDto(save);
	}

	@Override
	public DoctorDto update(Long id, DoctorDto doctorDto) {
		
		Doctor doctor = doctorRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Unable to find doctor's data"));
		if(!doctor.getEmail().equals(doctorDto.getEmail())) {
			
			doctorRepo.findByEmail(doctorDto.getEmail()).ifPresent(existing -> {throw new ResourceNotFoundException("this email is attached with another doctor");
			
		
			});
		}
		doctor.setEmail(doctorDto.getEmail());
		doctor.setAvailableFrom(doctorDto.getAvailableFrom());
		doctor.setAvailableTo(doctorDto.getAvailableTo());
		doctor.setConsultationFee(doctorDto.getConsultationFee());
		doctor.setExperienceYears(doctorDto.getExperienceYears());
		doctor.setFirstName(doctorDto.getFirstName());
		doctor.setGender(doctorDto.getGender());
		doctor.setLastName(doctorDto.getLastName());
		doctor.setMobileNumber(doctorDto.getMobileNumber());
		doctor.setSpecialization(doctorDto.getSpecialization());
		doctorRepo.save(doctor);
		return DoctorMapper.entityToDto(doctor);
	}

	@Override
	public void delete(Long id) {
		
		Doctor doctor = doctorRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Can not find Doctor data to delete"));
		
		doctorRepo.delete(doctor);
	}

	@Override
	public DoctorDto getById(Long id) {
		Doctor doctor = doctorRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Unable to fetch doctor data"));
		
		return DoctorMapper.entityToDto(doctor);
	}

	@Override
	public List<DoctorDto> getAll() {
		List<Doctor> list = doctorRepo.findAll();
		
		return list.stream().map(DoctorMapper::entityToDto).toList();
	}

}
