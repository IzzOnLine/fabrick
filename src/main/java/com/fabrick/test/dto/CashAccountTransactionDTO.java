package com.fabrick.test.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.fabrick.test.rest.exception.Error;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CashAccountTransactionDTO {

	private String status;
	private List<String> error;
	private CashAccountTransactionDTO payload;
	private List<Error> errors;

	private String transactionId;
	private String operationId;
	private LocalDate accountingDate;
	private LocalDate valueDate;
	private Type type;
	private BigDecimal amount;
	private String currency;
	private String description;

	private List<CashAccountTransactionDTO> list;

	@Data
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public static class Type {
		private String enumeration;
		private String value;
	}

}
