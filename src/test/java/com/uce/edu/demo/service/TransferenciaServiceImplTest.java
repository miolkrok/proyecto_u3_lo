package com.uce.edu.demo.service;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.math.BigDecimal;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;

import com.uce.edu.demo.repository.ICuentaBancariaRepository;


@SpringBootTest
class TransferenciaServiceImplTest {

	@Autowired
	private ITransferenciaService transferenciaService;
	
	@Autowired
	private ICuentaBancariaRepository cuentaBancariaRepository;
	 
	@Test
	@Transactional
	@Rollback(true)
	void testRealizarTransferencia() {
		this.transferenciaService.realizarTransferencia("96512", "58463", new BigDecimal(150));
		assertEquals(new BigDecimal(200).setScale(2), this.cuentaBancariaRepository.buscarPorNumero("58463").getSaldo());
	}

	@Test
	@Transactional
	@Rollback(true)
	void testRealizarTransferenciaFachada() {
		this.transferenciaService.realizarTransferencia("58463", "96512", new BigDecimal(50));
		assertNotEquals(new BigDecimal(50).setScale(2), this.cuentaBancariaRepository.buscarPorNumero("96512").getSaldo());
	}
	
	@Test
	@Transactional
	@Rollback(true)
	void testBuscar() {
		assertThat(this.transferenciaService.buscar(10)).isNotNull();
	}
	
	@Test
	@Transactional
	@Rollback(true)
	void testEliminar() {
		this.transferenciaService.eliminar(32);
		assertNull(this.transferenciaService.buscar(32));
	}
	

}
