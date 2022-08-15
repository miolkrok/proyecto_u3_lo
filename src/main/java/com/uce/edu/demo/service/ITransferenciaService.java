package com.uce.edu.demo.service;

import java.math.BigDecimal;

import com.uce.edu.demo.repository.modelo.Transferencia;

public interface ITransferenciaService {
	
	public void realizarTransferencia(String ctaOrigen, String ctaDestino, BigDecimal monto);
	public void realizarTransferenciaFachada(String ctaOrigen, String ctaDestino, BigDecimal monto);
	public Transferencia buscar(Integer id);
	public void eliminar(Integer id);

}
