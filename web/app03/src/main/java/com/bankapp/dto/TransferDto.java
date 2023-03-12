package com.bankapp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

//DTO 
@Data
@NoArgsConstructor
public class TransferDto {
	private int fromAccountId;
	private int toAccountId;
	private double amount;

}
