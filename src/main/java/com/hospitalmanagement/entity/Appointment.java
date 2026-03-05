package com.hospitalmanagement.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import com.hospitalmanagement.enum1.AppointmentStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Appointment extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long appointmentId;
	private LocalDate appointmentDate;
	private LocalTime appointmentTime;
	@Enumerated(EnumType.STRING)
	private AppointmentStatus bookedStatus;
	@ManyToOne
	@JoinColumn(name="doctor_id" , nullable = false)
	private Doctor doctor;
	@ManyToOne
	@JoinColumn(name="patient_id",nullable = false)
	private Patient patient;
	
}
