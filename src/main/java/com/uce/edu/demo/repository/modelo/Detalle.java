package com.uce.edu.demo.repository.modelo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "Detalle2")
@Table(name = "detalle2")
public class Detalle {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "name_generator")
	@SequenceGenerator(name = "name_generator", sequenceName = "deta_id_seq", allocationSize = 1)
	@Column(name = "deta_id")
	private Integer id;
	@Column(name = "deta_cantidad")
	private Integer cantidad;
	@Column(name = "deta_subtotal")
	private BigDecimal subtotal;
	@ManyToOne
	@JoinColumn(name = "deta_id_factura")
	private Factura factura;

	// SET Y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	@Override
	public String toString() {
		return "Detalle [id=" + id + ", cantidad=" + cantidad + ", subtotal=" + subtotal + ", factura=" + factura + "]";
	}

}
