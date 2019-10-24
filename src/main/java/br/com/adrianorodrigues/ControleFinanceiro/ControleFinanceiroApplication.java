package br.com.adrianorodrigues.ControleFinanceiro;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ControleFinanceiroApplication {

	private static final Logger logger = LoggerFactory.getLogger(ControleFinanceiroApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(ControleFinanceiroApplication.class, args);

	}

}
