package com.fabrick.test.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@Entity
@DynamicUpdate
public class CashAccountTransaction {

	@Id
	@Column(unique = true)
	private String transactionId;

	private String operationId;

	private LocalDate accountingDate;

	private LocalDate valueDate;

	@Enumerated(EnumType.STRING)
	private Type accountType;

	private BigDecimal amount;

	private String currency;

	private String description;

	public enum Type {
		GBS_ACCOUNT_TRANSACTION_TYPE_0009, GBS_ACCOUNT_TRANSACTION_TYPE_0039, GBS_ACCOUNT_TRANSACTION_TYPE_0010,
		GBS_ACCOUNT_TRANSACTION_TYPE_0078, GBS_ACCOUNT_TRANSACTION_TYPE_0050, GBS_ACCOUNT_TRANSACTION_TYPE_0034
	}

}
