package com.hospitalmanagement.service;

import java.util.List;

import com.hospitalmanagement.dto.AppointmentDto;

public interface AppointmentService {

	public AppointmentDto create(AppointmentDto appointmentDto);
	public AppointmentDto update(Long appointmentId,AppointmentDto appointmentDto);
	public void delete(Long id);
	public AppointmentDto getById(Long appointmentId);
	public List<AppointmentDto> getAll();
}
