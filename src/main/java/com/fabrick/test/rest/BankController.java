package com.fabrick.test.rest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fabrick.test.dto.CashAccountBalanceDTO;
import com.fabrick.test.dto.CashAccountTransactionDTO;
import com.fabrick.test.dto.MoneyTransferDTO;
import com.fabrick.test.dto.MoneyTransferResponseDTO;
import com.fabrick.test.service.BankService;

@RestController
@RequestMapping("/account")
public class BankController {

	private static final String TO_ACCOUNTING_DATE = "toAccountingDate";

	private static final String FROM_ACCOUNTING_DATE = "fromAccountingDate";

	private static final String DATE_PATTERN = "yyyy-MM-dd";

	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);

	@Autowired
	private BankService bankService;

	@GetMapping("/balance")
	public CashAccountBalanceDTO getCashAccountBalance() {
		return bankService.getCashAccountBalance();
	}

	@GetMapping("/transactions")
	public CashAccountTransactionDTO getCashAccountTransactions(@RequestParam String from, @RequestParam String to) {
		LocalDate fromAccountingDate = LocalDate.parse(from);
		LocalDate toAccountingDate = LocalDate.parse(to);
		Map<String, String> uriQuery = new HashMap<String, String>();
		uriQuery.put(FROM_ACCOUNTING_DATE, fromAccountingDate.format(FORMATTER));
		uriQuery.put(TO_ACCOUNTING_DATE, toAccountingDate.format(FORMATTER));
		return bankService.getCashAccountTransactions(uriQuery);
	}

	@PostMapping("/money-transfers")
	public MoneyTransferResponseDTO createMoneyTranfers(@RequestBody MoneyTransferDTO moneyTransfer) {
		return bankService.createMoneyTranfers(moneyTransfer);
	}

}
