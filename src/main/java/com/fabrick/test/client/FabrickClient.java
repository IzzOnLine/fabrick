package com.fabrick.test.client;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fabrick.test.dto.CashAccountBalanceDTO;
import com.fabrick.test.dto.CashAccountTransactionDTO;
import com.fabrick.test.dto.MoneyTransferDTO;
import com.fabrick.test.dto.MoneyTransferResponseDTO;

@FeignClient(value = "fabrick-client", url = "${fabrick.api-url}", configuration = FabrickClientSettings.class)
public interface FabrickClient {

	@RequestMapping(method = RequestMethod.GET, value = "/api/gbs/banking/v4.0/accounts/{accountId}/balance", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	CashAccountBalanceDTO getCashAccountBalance(@PathVariable(name = "accountId") String accountId);

	@RequestMapping(method = RequestMethod.GET, value = "/api/gbs/banking/v4.0/accounts/{accountId}/transactions", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	CashAccountTransactionDTO getCashAccountTransaction(@PathVariable(name = "accountId") String accountId,
			@SpringQueryMap Map<String, String> uriQuery);

	@RequestMapping(method = RequestMethod.POST, value = "/api/gbs/banking/v4.0/accounts/{accountId}/payments/money-transfers", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	MoneyTransferResponseDTO moneyTransfer(@PathVariable(name = "accountId") String accountId,
			@RequestBody MoneyTransferDTO moneyTransfer);

}
