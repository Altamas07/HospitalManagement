package com.hospitalmanagement.mapper;

import com.hospitalmanagement.dto.AppointmentDto;
import com.hospitalmanagement.entity.Appointment;
import com.hospitalmanagement.entity.Doctor;
import com.hospitalmanagement.entity.Patient;

public class AppointmentMapper {

	public static AppointmentDto entityToDto(Appointment appointment) {

		AppointmentDto app = new AppointmentDto();
		app.setAppointmentDate(appointment.getAppointmentDate());
		app.setAppointmentId(appointment.getAppointmentId());
		app.setAppointmentTime(appointment.getAppointmentTime());
		app.setDoctorId(appointment.getDoctor().getId());
		app.setPatientId(appointment.getPatient().getId());
		return app;
	}

	public static Appointment dtoToEntity(AppointmentDto appointment, Doctor doctor, Patient patient) {

		Appointment app = new Appointment();
		app.setAppointmentDate(appointment.getAppointmentDate());
		app.setAppointmentId(appointment.getAppointmentId());
		app.setAppointmentTime(appointment.getAppointmentTime());
		app.setDoctor(doctor);
		app.setPatient(patient);
		return app;
	}
}
