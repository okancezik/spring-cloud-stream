package com.okancezik.cashcard.domain.cashcard;

public record CashCard(
		Long id,
		String owner,
		Double amountRequestedForAuth
) { }
