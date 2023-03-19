package com.bankapp.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TransferDto {

	private int fromAccId;
	private int toAccId;
	private BigDecimal amount;
	
	public TransferDto(int fromAccId, int toAccId, BigDecimal amount) {
		this.fromAccId = fromAccId;
		this.toAccId = toAccId;
		this.amount = amount;
	}
	
	
}
