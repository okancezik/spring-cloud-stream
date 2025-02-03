package com.okancezik.cashcard.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.okancezik.cashcard.domain.cashcard.CashCard;
import com.okancezik.cashcard.domain.transaction.Transaction;
import com.okancezik.cashcard.service.DataSourceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.binder.test.OutputDestination;
import org.springframework.cloud.stream.binder.test.TestChannelBinderConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import static org.mockito.BDDMockito.given;

import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.messaging.Message;

import java.io.IOException;

@SpringBootTest
@Import(TestChannelBinderConfiguration.class)
class CashCardApplicationTests {
	@MockitoBean
	private DataSourceService dataSourceService;

	@Test
	void basicCashCardSupplier(@Autowired OutputDestination outputDestination) throws IOException {
		Transaction testTransaction = new Transaction(
				1L,
				new CashCard(
						123L,
						"Sarah1",
						1.00)
		);
		given(dataSourceService.getData()).willReturn(testTransaction);
		Message<byte[]> result = outputDestination.receive(
				5000,
				"approvalRequest-out-0"
		);
		assertThat(result).isNotNull();

		// Deserialize the transaction and inspect it
		ObjectMapper objectMapper = new ObjectMapper();
		Transaction transaction = objectMapper.readValue(result.getPayload(), Transaction.class);
		assertThat(transaction.id()).isEqualTo(1L);
		assertThat(transaction.cashCard()).isEqualTo(testTransaction.cashCard());
	}
}
