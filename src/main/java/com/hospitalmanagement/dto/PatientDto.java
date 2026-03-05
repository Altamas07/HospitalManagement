package com.hospitalmanagement.dto;

import java.time.LocalDate;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.hospitalmanagement.enum1.BloodGroup;
import com.hospitalmanagement.enum1.Gender;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {

	@JsonProperty(access = Access.READ_ONLY)
	private Long id;
	@NotBlank
	private String firstName;
	@NotBlank
	private String lastName;
	@NotNull
	private Gender gender;
	@NotNull
	@Past
	private LocalDate dateOfBirth;
	@NotBlank
	@Column(unique = true)
	private String mobileNumber;
	@Email
	@Column(unique = true)
	private String email;
	@NotBlank
	private String city;
	@NotBlank
	private String state;
	@NotBlank
	private String pincode;
	@NotNull
	private BloodGroup bloodGroup;
	
}
