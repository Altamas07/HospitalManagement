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

import com.hospitalmanagement.dto.AppointmentDto;
import com.hospitalmanagement.service.AppointmentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/appointments")
@RequiredArgsConstructor
public class AppointmentController {

	private final AppointmentService appointmentService;
	@PostMapping("/create")
	public AppointmentDto create(@Valid @RequestBody AppointmentDto appointmentDto) {
		
		AppointmentDto appointmentDto2 = appointmentService.create(appointmentDto);
		return appointmentDto2;
	}
	
	@PutMapping("/update/{appointmentId}")
	public AppointmentDto update(@PathVariable("appointmentId") Long appointmentId,@Valid @RequestBody AppointmentDto appointmentDto) {
		AppointmentDto appointmentDto2 = appointmentService.update(appointmentId, appointmentDto);
		return appointmentDto2;
	}
	@DeleteMapping("/delete/{appointmentId}")
	public void delete(@PathVariable("appointmentId") Long appointmentId) {
		
		appointmentService.delete(appointmentId);
	}
	@GetMapping("/getById/{appointmentId}")
	public AppointmentDto getById(@PathVariable("appointmentId") Long appointmentId) {
		
		AppointmentDto appointmentDto = appointmentService.getById(appointmentId);
		return appointmentDto;
	}
	@GetMapping("/getAll")
	public List<AppointmentDto> getAll() {
		List<AppointmentDto> list = appointmentService.getAll();
		return list;
	}
	
	
	
	
	
}
