package com.hospitalmanagement.entity;

import java.time.LocalTime;
import java.util.List;

import com.hospitalmanagement.enum1.DoctorSpecialization;
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
public class Doctor extends BaseEntity{
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String lastName;
	private Gender gender;
	@Enumerated(EnumType.STRING)
	private DoctorSpecialization specialization;
	private String mobileNumber;
	private Integer experienceYears;
	private Integer consultationFee;
	private LocalTime availableFrom;
	private LocalTime availableTo;
	private String email;
	@OneToMany(mappedBy = "doctor")
	private List<Appointment> appointment;
}
