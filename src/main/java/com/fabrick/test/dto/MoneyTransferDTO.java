package com.fabrick.test.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MoneyTransferDTO {

	private CreditorDTO creditor;
	private Date executionDate;
	private String uri;
	private String description;
	private BigDecimal amount;
	private String currency;
	@JsonProperty("isUrgent")
	private boolean isUrgent;
	@JsonProperty("isInstant")
	private boolean isInstant;
	private FeeType feeType;
	private String feeAccountId;
	private TaxReliefDTO taxRelief;

	public enum FeeType {
		SHA, OUR, BEN
	}

	@Data
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public static class CreditorDTO {

		private String name;
		private AccountDTO account;
		private AddressDTO address;

		@Data
		@JsonInclude(JsonInclude.Include.NON_NULL)
		private static class AccountDTO {
			private String accountCode;
			private String bicCode;
		}

		@Data
		@JsonInclude(JsonInclude.Include.NON_NULL)
		private static class AddressDTO {
			private String address;
			private String city;
			private String countryCode;
		}
	}

	@Data
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public static class TaxReliefDTO {
		private String taxReliefId;
		@JsonProperty("isCondoUpgrade")
		private boolean isCondoUpgrade;
		private String creditorFiscalCode;
		private BeneficiaryType beneficiaryType;
		private NaturalPersonBeneficiaryDTO naturalPersonBeneficiary;
		private LegalPersonBeneficiaryDTO legalPersonBeneficiary;

		@Data
		@JsonInclude(JsonInclude.Include.NON_NULL)
		private static class NaturalPersonBeneficiaryDTO {
			private String fiscalCode1;
			private String fiscalCode2;
			private String fiscalCode3;
			private String fiscalCode4;
			private String fiscalCode5;
		}

		@Data
		@JsonInclude(JsonInclude.Include.NON_NULL)
		private static class LegalPersonBeneficiaryDTO {
			private String fiscalCode;
			private String legalRepresentativeFiscalCode;
		}

		public enum BeneficiaryType {
			NATURAL_PERSON, LEGAL_PERSON
		}
	}

}
