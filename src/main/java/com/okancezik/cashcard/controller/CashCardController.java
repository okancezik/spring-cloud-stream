package com.okancezik.cashcard.controller;

import com.okancezik.cashcard.domain.transaction.Transaction;
import com.okancezik.cashcard.ondemand.CashCardTransactionOnDemand;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CashCardController {

	private final CashCardTransactionOnDemand cashCardTransactionOnDemand;

	@PostMapping(path = "/publish/txn")
	public void publishTxn(@RequestBody Transaction transaction) {
		cashCardTransactionOnDemand.publishOnDemand(transaction);
	}
}
