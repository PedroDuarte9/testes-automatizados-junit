package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

class ReajusteServiceTest {
	
	private ReajusteService service;
	private Funcionario funcionario;
	
	/*Outras Anotações
	 * @BeforeAll
	 * @AfterEach
	 * @AfterAll*/
	
	@BeforeEach
	public void inicializar() {
		this.service = new ReajusteService();
		this.funcionario =  new Funcionario("Pedro", LocalDate.now(), new BigDecimal("1000.00"));
	}
	
	

	@Test
	void ReajusteSalarioADesejar() {
		service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
		
		assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
	}
	
	@Test
	void ReajusteSalarioBom() {
		service.concederReajuste(funcionario, Desempenho.BOM);
		
		assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
	}
	
	@Test
	void ReajusteSalarioOtimo() {
		service.concederReajuste(funcionario, Desempenho.OTIMO);
		
		assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
	}
		
}
