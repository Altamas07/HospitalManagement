package com.hospitalmanagement.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hospitalmanagement.dto.AppointmentDto;
import com.hospitalmanagement.entity.Appointment;
import com.hospitalmanagement.entity.Doctor;
import com.hospitalmanagement.entity.Patient;
import com.hospitalmanagement.exception.ResourceNotFoundException;
import com.hospitalmanagement.mapper.AppointmentMapper;
import com.hospitalmanagement.repository.AppointmentRepo;
import com.hospitalmanagement.repository.DoctorRepo;
import com.hospitalmanagement.repository.PatientRepo;
import com.hospitalmanagement.service.AppointmentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService{

    private final DoctorRepo doctorRepo;

    private final PatientRepo patientRepo;
	private final AppointmentRepo appointmentRepo;

   
	@Override
	public AppointmentDto create(AppointmentDto appointmentDto) {
		Doctor doctor = doctorRepo.findById(appointmentDto.getDoctorId()).orElseThrow(()-> new ResourceNotFoundException("doctor not found"));
		
		Patient patient = patientRepo.findById(appointmentDto.getPatientId()).orElseThrow(()-> new ResourceNotFoundException("patient not found"));
		
		Appointment app=new Appointment();
		app.setAppointmentDate(appointmentDto.getAppointmentDate());
		app.setAppointmentTime(appointmentDto.getAppointmentTime());
		app.setBookedStatus(appointmentDto.getBookedStatus());
		app.setDoctor(doctor);
		app.setPatient(patient);
		Appointment appointment = appointmentRepo.save(app);
		return AppointmentMapper.entityToDto(appointment) ;
	}

	@Override
	public AppointmentDto update(Long appointmentId, AppointmentDto appointmentDto) {
		
		Appointment appointment = appointmentRepo.findById(appointmentId).orElseThrow(()->new ResourceNotFoundException("Could not found appointment details"));
		
		if(!appointment.getDoctor().getId().equals(appointmentDto.getDoctorId())) {
			
			Doctor doctor = doctorRepo.findById(appointmentDto.getDoctorId()).orElseThrow(()-> new ResourceNotFoundException("Doctor not found"));
			appointment.setDoctor(doctor);
		}
		if(!appointment.getPatient().getId().equals(appointmentDto.getPatientId())) {
			
			Patient patient = patientRepo.findById(appointmentDto.getPatientId()).orElseThrow(()-> new ResourceNotFoundException("Patient not found"));
			appointment.setPatient(patient);
		}
		appointment.setAppointmentDate(appointmentDto.getAppointmentDate());
		appointment.setAppointmentTime(appointmentDto.getAppointmentTime());
		appointment.setBookedStatus(appointmentDto.getBookedStatus());
		
		appointmentRepo.save(appointment);
		return AppointmentMapper.entityToDto(appointment);
	}

	@Override
	public void delete(Long appointmentId) {
	
		Appointment appointment = appointmentRepo.findById(appointmentId).orElseThrow(()-> new ResourceNotFoundException("Unable to find appointment"));
		appointmentRepo.delete(appointment);
	}

	@Override
	public AppointmentDto getById(Long appointmentId) {
		Appointment appointment = appointmentRepo.findById(appointmentId).orElseThrow(()->
		new ResourceNotFoundException("Could not found appoinment"));
		return AppointmentMapper.entityToDto(appointment) ;
	}

	@Override
	public List<AppointmentDto> getAll() {
		
		List<Appointment> list = appointmentRepo.findAll();
		return list.stream().map(AppointmentMapper::entityToDto).toList();
	}

}
