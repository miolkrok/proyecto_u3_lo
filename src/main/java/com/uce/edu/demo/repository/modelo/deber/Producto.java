package com.uce.edu.demo.repository.modelo.deber;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "name_generator")
	@SequenceGenerator(name = "name_generator", sequenceName = "prod_id_seq", allocationSize = 1)
	@Column(name = "prod_id")
	private Integer id;
	@Column(name = "prod_nombre")
	private String nombre;
	@Column(name = "prod_precio")
	private BigDecimal precio;
	@Column(name = "prod_stock")
	private Integer stock;
	
	@Column(name = "prod_codigo_barras")
	private String codigoBarras;
	
	@OneToMany(mappedBy = "producto",cascade = CascadeType.ALL)
	private List<DetalleFactura> detaFactProd;

	//SET Y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public List<DetalleFactura> getDetaFactProd() {
		return detaFactProd;
	}

	public void setDetaFactProd(List<DetalleFactura> detaFactProd) {
		this.detaFactProd = detaFactProd;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", stock=" + stock
				+ ", codigoBarras=" + codigoBarras + ", detaFactProd=" + detaFactProd + "]";
	}




	

}
