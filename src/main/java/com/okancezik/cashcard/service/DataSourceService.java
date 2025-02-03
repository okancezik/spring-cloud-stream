package com.okancezik.cashcard.service;

import com.okancezik.cashcard.domain.cashcard.CashCard;
import com.okancezik.cashcard.domain.transaction.Transaction;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class DataSourceService {
	private final Random random = new Random();

	public Transaction getData() {
		CashCard cashCard = new CashCard(
				random.nextLong(),
				"Sarah1",
				random.nextDouble(100.00)
		);
		Transaction transaction = new Transaction(
				random.nextLong(),
				cashCard
		);
		log.info("Transaction has been generated: {}", transaction);
		return transaction;
	}
}
