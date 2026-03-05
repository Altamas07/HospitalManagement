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

import com.hospitalmanagement.dto.DoctorDto;
import com.hospitalmanagement.service.DoctorService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/doctors")
@RequiredArgsConstructor
public class DoctorController {

	private final DoctorService doctorService;
	
	@PostMapping("/create")
	public DoctorDto create( @Valid @RequestBody DoctorDto doctorDto) {
		
		DoctorDto dto = doctorService.create(doctorDto);
		return dto;
	}
	@PutMapping("/update/{id}")
	public DoctorDto update(@PathVariable("id") Long id ,@Valid @RequestBody DoctorDto doctorDto) {
		
		DoctorDto update = doctorService.update(id, doctorDto);
		return update;
	}
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") Long id) {
		
		doctorService.delete(id);
	}
	@GetMapping("/getById/{id}")
	public DoctorDto getById(@PathVariable("id") Long id) {
		
		DoctorDto doctorDto = doctorService.getById(id);
		return doctorDto;
	}
	@GetMapping("/getAll")
	public List<DoctorDto> getAll() {
		
		List<DoctorDto> list = doctorService.getAll();
		
		return list;
		
	}
}
