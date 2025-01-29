package com.okancezik.cashcard.domain.transaction;

import com.okancezik.cashcard.domain.cashcard.CashCard;

public record Transaction(
		Long id,
		CashCard cashCard
) {
}
