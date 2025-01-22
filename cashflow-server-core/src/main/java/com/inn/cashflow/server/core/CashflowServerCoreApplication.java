package com.inn.cashflow.server.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class CashflowServerCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(CashflowServerCoreApplication.class, args);
	}

}
