package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ICuentaBancariaRepository;
import com.uce.edu.demo.repository.ITransferenciaRepository;
import com.uce.edu.demo.repository.modelo.CuentaBancaria;
import com.uce.edu.demo.repository.modelo.Transferencia;

@Service
public class TransferenciaServiceImpl implements ITransferenciaService {

	@Autowired
	private ICuentaBancariaRepository bancariaRepository;
	
	@Autowired
	private ITransferenciaRepository transferenciaRepository;
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void realizarTransferencia(String numeroCtaOrigen, String numeroCtaDestino, BigDecimal monto) {
		// TODO Auto-generated method stub
		//0. Busque la cta Origen (obtener el saldo)
		CuentaBancaria ctaOrigen = this.bancariaRepository.buscarPorNumero(numeroCtaOrigen);
		//1. restar el monto a la cuenta origen
		BigDecimal saldoOrigen = ctaOrigen.getSaldo();
		BigDecimal saldoFinal = saldoOrigen.subtract(monto);
		ctaOrigen.setSaldo(saldoFinal);
		this.bancariaRepository.actualizar(ctaOrigen);
		//0. Busque la cta Destino (obtener el saldo)
		CuentaBancaria ctaDestino = this.bancariaRepository.buscarPorNumero(numeroCtaDestino);
		//2. sumar el monto a la cuenta Destino
		ctaDestino.setSaldo(ctaDestino.getSaldo().add(monto));
		this.bancariaRepository.actualizar(ctaDestino);
		//3. insertar Transferencia
		Transferencia tran = new Transferencia();
		tran.setFecha(LocalDateTime.now());
		tran.setMonto(monto);
		tran.setCuentaOrigen(ctaOrigen);
		tran.setCuentaDestino(ctaDestino);
		this.transferenciaRepository.insertar(tran);
//		if(ctaOrigen.getTipo().equals("Ahorros")) {
//			throw new RuntimeException();
//		}
		if(saldoFinal.compareTo(monto)>0) {
			throw new RuntimeException();
		}
		
		
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void realizarTransferenciaFachada(String ctaOrigen, String ctaDestino, BigDecimal monto) {
		// TODO Auto-generated method stub
		this.realizarTransferencia(ctaOrigen, ctaDestino, monto);
	}

	@Override
	@Transactional
	public Transferencia buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.transferenciaRepository.buscar(id);
	}

	@Override
	@Transactional
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.transferenciaRepository.eliminar(id);
	}

}
