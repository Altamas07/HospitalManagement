package com.hospitalmanagement.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.hospitalmanagement.enum1.AppointmentStatus;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDto {

	@JsonProperty(access = Access.READ_ONLY)
	private Long appointmentId;
	@NotNull
	private LocalDate appointmentDate;
	@NotNull
	private LocalTime appointmentTime;
	@NotNull
	private Long doctorId;
	@NotNull
	private Long patientId;
	@NotNull
	private AppointmentStatus bookedStatus;
}
