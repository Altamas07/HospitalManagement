package com.hospitalmanagement.mapper;

import com.hospitalmanagement.dto.DoctorDto;
import com.hospitalmanagement.entity.Doctor;

public class DoctorMapper {

	public static DoctorDto entityToDto(Doctor doctor) {
		DoctorDto dct=new DoctorDto();
		dct.setAvailableFrom(doctor.getAvailableFrom());
		dct.setAvailableTo(doctor.getAvailableTo());
		dct.setConsultationFee(doctor.getConsultationFee());
		dct.setEmail(doctor.getEmail());
		dct.setExperienceYears(doctor.getExperienceYears());
		dct.setFirstName(doctor.getFirstName());
		dct.setGender(doctor.getGender());
		dct.setId(doctor.getId());
		dct.setLastName(doctor.getLastName());
		dct.setMobileNumber(doctor.getMobileNumber());
		dct.setSpecialization(doctor.getSpecialization());
		
		return dct;
	}
		public static Doctor dtoToEntity(DoctorDto doctor) {
			Doctor dct=new Doctor();
			dct.setAvailableFrom(doctor.getAvailableFrom());
			dct.setAvailableTo(doctor.getAvailableTo());
			dct.setConsultationFee(doctor.getConsultationFee());
			dct.setEmail(doctor.getEmail());
			dct.setExperienceYears(doctor.getExperienceYears());
			dct.setFirstName(doctor.getFirstName());
			dct.setGender(doctor.getGender());
			dct.setId(doctor.getId());
			dct.setLastName(doctor.getLastName());
			dct.setMobileNumber(doctor.getMobileNumber());
			dct.setSpecialization(doctor.getSpecialization());
			
			return dct;
	}
}
