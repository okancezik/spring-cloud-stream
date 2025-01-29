package com.okancezik.cashcard.service;

import com.okancezik.cashcard.domain.cashcard.CashCard;
import com.okancezik.cashcard.domain.transaction.Transaction;

import java.util.Random;

public class DataSourceService {
	private final Random random = new Random();

	public Transaction getData() {
		CashCard cashCard = new CashCard(
				random.nextLong(),
				"Sarah1",
				random.nextDouble(100.00)
		);
		return new Transaction(
				random.nextLong(),
				cashCard
		);
	}
}
