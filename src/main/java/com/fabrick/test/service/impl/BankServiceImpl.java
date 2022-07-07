package com.fabrick.test.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.fabrick.test.client.FabrickClient;
import com.fabrick.test.dto.CashAccountBalanceDTO;
import com.fabrick.test.dto.CashAccountTransactionDTO;
import com.fabrick.test.dto.MoneyTransferDTO;
import com.fabrick.test.dto.MoneyTransferResponseDTO;
import com.fabrick.test.entities.CashAccountTransaction;
import com.fabrick.test.entities.CashAccountTransaction.Type;
import com.fabrick.test.repository.CashAccountTransactionRepository;
import com.fabrick.test.service.BankService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Service
public class BankServiceImpl implements BankService {

	@Autowired
	private FabrickClient fabrickClient;

	@Autowired
	private CashAccountTransactionRepository repository;

	@Value("${fabrick.account-id}")
	private String ACCOUNT_ID;

	@Override
	public CashAccountBalanceDTO getCashAccountBalance() {
		return fabrickClient.getCashAccountBalance(ACCOUNT_ID);

	}

	@Override
	public CashAccountTransactionDTO getCashAccountTransactions(Map<String, String> uriQuery) {
		CashAccountTransactionDTO retVal = fabrickClient.getCashAccountTransaction(ACCOUNT_ID, uriQuery);

		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

		if (retVal.getPayload() != null && !CollectionUtils.isEmpty(retVal.getPayload().getList()))
			for (CashAccountTransactionDTO dto : retVal.getPayload().getList()) {
				CashAccountTransaction entity = mapper.convertValue(dto, new TypeReference<CashAccountTransaction>() {
				});
				if (dto.getType() != null && dto.getType().getValue() != null)
					entity.setAccountType(Type.valueOf(dto.getType().getValue()));
				repository.save(entity);
			}
		return retVal;

	}

	@Override
	public MoneyTransferResponseDTO createMoneyTranfers(MoneyTransferDTO moneyTransfer) {
		return fabrickClient.moneyTransfer(ACCOUNT_ID, moneyTransfer);

	}

}
