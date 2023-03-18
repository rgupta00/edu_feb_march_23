package com.bankapp.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class WithdrawDto {

	private int id;
	private BigDecimal amount;
	
	public WithdrawDto(int id, BigDecimal amount) {
		this.id = id;
		this.amount = amount;
	}
	

}
