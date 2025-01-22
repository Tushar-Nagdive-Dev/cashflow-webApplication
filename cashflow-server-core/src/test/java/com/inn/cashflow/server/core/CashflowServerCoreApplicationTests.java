package com.inn.cashflow.server.core;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = {
    "logging.config=classpath:logback-spring.xml"
})
class CashflowServerCoreApplicationTests {

	@Test
	void contextLoads() {
	}

}
