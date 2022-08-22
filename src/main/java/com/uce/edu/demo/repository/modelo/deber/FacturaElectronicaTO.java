package com.uce.edu.demo.repository.modelo.deber;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FacturaElectronicaTO {
	
	private Integer id;
	private String numero;
	private LocalDateTime fecha;
	private BigDecimal monto;
	private Integer numeroItems;
	
	public FacturaElectronicaTO() {
		// TODO Auto-generated constructor stub
	}
	
	public FacturaElectronicaTO(Integer id, String numero, LocalDateTime fecha, BigDecimal monto, Integer numeroItems) {
		super();
		this.id = id;
		this.numero = numero;
		this.fecha = fecha;
		this.monto = monto;
		this.numeroItems = numeroItems;
	}
	//set y get

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public Integer getNumeroItems() {
		return numeroItems;
	}

	public void setNumeroItems(Integer numeroItems) {
		this.numeroItems = numeroItems;
	}

	
	

}
