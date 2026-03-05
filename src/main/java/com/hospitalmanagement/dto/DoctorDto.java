package com.hospitalmanagement.dto;

import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.hospitalmanagement.enum1.DoctorSpecialization;
import com.hospitalmanagement.enum1.Gender;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDto {
	@JsonProperty(access = Access.READ_ONLY)
	private Long id;
	@NotBlank
	private String firstName;
	@NotBlank
	private String lastName;
	@NotNull
	private Gender gender;
	@NotNull
	private DoctorSpecialization specialization;
	@NotBlank
	private String mobileNumber;
	@NotNull
	private Integer experienceYears;
	@NotNull
	private Integer consultationFee;
	@NotNull
	private LocalTime availableFrom;
	@NotNull
	private LocalTime availableTo;
	@NotBlank
	@Email
	private String email;
}
