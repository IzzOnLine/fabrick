package com.fabrick.test.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.fabrick.test.dto.MoneyTransferDTO.CreditorDTO;
import com.fabrick.test.dto.MoneyTransferDTO.FeeType;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MoneyTransferResponseDTO {

	private String moneyTransferId;
	private Status status;
	private Direction direction;
	private CreditorDTO creditor;
	private CreditorDTO debtor;
	private String cro;
	private String uri;
	private String trn;
	private String description;
	private LocalDateTime createdDatetime; // 2019-04-10T10:38:56.000+0200
	private LocalDateTime accountedDatetime; // 2019-04-10T10:38:56.000+0200
	private LocalDate debtorValueDate; // 2019-04-10
	private LocalDate creditorValueDate; // 2019-04-10
	private AmountDTO amount;
	private boolean isUrgent;
	private boolean isInstant;
	private FeeType feeType;
	private String feeAccountId;
	private List<FeeDTO> fees;
	private boolean hasTaxRelief;

	public enum Status {
		EXECUTED, BOOKED, WORK_IN_PROGRESS, CANCELLED, REJECTED
	}

	public enum Direction {
		INCOMING, OUTGOING
	}

	@Data
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public static class AmountDTO {
		private BigDecimal debtorAmount;
		private String debtorCurrency;
		private BigDecimal creditorAmount;
		private String creditorCurrency;
		private LocalDate creditorCurrencyDate;
		private Integer exchangeRate;
	}

	@Data
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public static class FeeDTO {
		private String feeCode;
		private String description;
		private BigDecimal amount;
		private String currency;
	}

}
