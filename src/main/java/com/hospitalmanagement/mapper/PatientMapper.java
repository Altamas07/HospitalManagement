package com.hospitalmanagement.mapper;

import com.hospitalmanagement.dto.PatientDto;
import com.hospitalmanagement.entity.Patient;

public class PatientMapper {

	public static PatientDto entityToDto(Patient patient) {

		PatientDto pt = new PatientDto();
		pt.setBloodGroup(patient.getBloodGroup());
		pt.setCity(patient.getCity());
		pt.setDateOfBirth(patient.getDateOfBirth());
		pt.setEmail(patient.getEmail());
		pt.setFirstName(patient.getFirstName());
		pt.setGender(patient.getGender());
		pt.setId(patient.getId());
		pt.setLastName(patient.getLastName());
		pt.setMobileNumber(patient.getMobileNumber());
		pt.setPincode(patient.getPincode());
		pt.setState(patient.getState());

		return pt;

	}

	public static Patient dtoToEntity(PatientDto patient) {

		Patient pt = new Patient();
		pt.setBloodGroup(patient.getBloodGroup());
		pt.setCity(patient.getCity());
		pt.setDateOfBirth(patient.getDateOfBirth());
		pt.setEmail(patient.getEmail());
		pt.setFirstName(patient.getFirstName());
		pt.setGender(patient.getGender());
		pt.setId(patient.getId());
		pt.setLastName(patient.getLastName());
		pt.setMobileNumber(patient.getMobileNumber());
		pt.setPincode(patient.getPincode());
		pt.setState(patient.getState());

		return pt;

	}

}
