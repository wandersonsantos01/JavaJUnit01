package br.com.alura.tdd.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

	@Test
	void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
		BonusService service = new BonusService();

		// WAY 1
		assertThrows(
				IllegalArgumentException.class,
				() -> service.calcularBonus(new Funcionario("Pedro", LocalDate.now(), new BigDecimal("11000")))
		);

		// WAY 2
		try {
			service.calcularBonus(new Funcionario("Pedro", LocalDate.now(), new BigDecimal("11000")));
			fail("Não lançou exception que deveria");
		} catch (Exception e) {
			assertEquals("Funcionário com salário maior que permito para receber bonus", e.getMessage());
		}

	}

	@Test
	void bonusDeveriaSer10PorCentoDoSalario() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("João", LocalDate.now(), new BigDecimal("5000")));

		assertEquals(new BigDecimal("500.00"), bonus);
	}

	@Test
	void bonusDeveriaSerDezPorCentoParaSalarioDeExatamente10000() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Paulo", LocalDate.now(), new BigDecimal("10000")));

		assertEquals(new BigDecimal("1000.00"), bonus);
	}

}
