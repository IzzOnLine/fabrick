package com.fabrick.test.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.fabrick.test.rest.exception.Error;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CashAccountBalanceDTO {

	private String status;
	private List<String> error;
	private CashAccountBalanceDTO payload;
	private List<Error> errors;

	private LocalDate date;
	private BigDecimal balance;
	private BigDecimal availableBalance;
	private String currency;

}
