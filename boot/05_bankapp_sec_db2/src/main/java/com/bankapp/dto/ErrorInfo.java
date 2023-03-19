package com.bankapp.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorInfo {
	private String errorMessage;
	private String statusCode;
	private String toContact;
	private LocalDateTime timeStamp;
	
}
