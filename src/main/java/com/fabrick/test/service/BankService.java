package com.fabrick.test.service;

import java.util.Map;

import com.fabrick.test.dto.CashAccountBalanceDTO;
import com.fabrick.test.dto.CashAccountTransactionDTO;
import com.fabrick.test.dto.MoneyTransferDTO;
import com.fabrick.test.dto.MoneyTransferResponseDTO;

public interface BankService {

	CashAccountBalanceDTO getCashAccountBalance();

	CashAccountTransactionDTO getCashAccountTransactions(Map<String, String> uriQuery);

	MoneyTransferResponseDTO createMoneyTranfers(MoneyTransferDTO moneyTransfer);

}
