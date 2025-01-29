package com.okancezik.cashcard.stream;

import com.okancezik.cashcard.domain.transaction.Transaction;
import com.okancezik.cashcard.service.DataSourceService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Supplier;

@Configuration
public class CashCardStream {
	@Bean
	public Supplier<Transaction> approvalRequest(DataSourceService dataSourceService) {
		return dataSourceService::getData;
	}

	@Bean
	public DataSourceService dataSourceService() {
		return new DataSourceService();
	}
}
