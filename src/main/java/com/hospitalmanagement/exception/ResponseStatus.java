package com.hospitalmanagement.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ResponseStatus {

	 private String message;
	 private int status;
	 private LocalDateTime localDateTime;
}
