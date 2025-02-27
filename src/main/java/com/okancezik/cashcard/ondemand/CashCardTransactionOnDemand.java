package com.okancezik.cashcard.ondemand;

import com.okancezik.cashcard.domain.transaction.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class CashCardTransactionOnDemand {
	private final StreamBridge streamBridge;

	public CashCardTransactionOnDemand(StreamBridge streamBridge) {
		this.streamBridge = streamBridge;
	}

	public void publishOnDemand(Transaction transaction) {
		log.info("Transaction has been send to message broker:{}", transaction);
		this.streamBridge.send("approvalRequest-out-0", transaction);
	}
}