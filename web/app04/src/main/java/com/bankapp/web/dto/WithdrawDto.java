package com.bankapp.web.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

//DTO 
@Data
@NoArgsConstructor
public class WithdrawDto {
	private int accountId;
	private double amount;

}
