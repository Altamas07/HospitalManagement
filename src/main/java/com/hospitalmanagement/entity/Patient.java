package com.hospitalmanagement.entity;

import java.util.List;
import java.time.LocalDate;

import com.hospitalmanagement.enum1.BloodGroup;
import com.hospitalmanagement.enum1.Gender;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Patient extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String lastName;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	private LocalDate dateOfBirth;
	private String mobileNumber;
	private String email;
	private String city;
	private String state;
	private String pincode;
	private BloodGroup bloodGroup;
	@OneToMany(mappedBy = "patient")
	private List<Appointment> appointment;
	
	
}
