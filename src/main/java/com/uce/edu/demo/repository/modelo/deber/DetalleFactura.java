package com.uce.edu.demo.repository.modelo.deber;

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

import com.uce.edu.demo.repository.modelo.Factura;

@Entity
@Table(name = "detalle_factura")
public class DetalleFactura {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "name_generator")
	@SequenceGenerator(name = "name_generator", sequenceName = "defa_id_seq", allocationSize = 1)
	@Column(name = "defa_id")
	private Integer id;
	@Column(name = "defa_cantidad")
	private Integer cantidad;
	@Column(name = "defa_subtotal")
	private BigDecimal subtotal;
	@Column(name = "defa_numero_items")
	private Integer numeroItems;
	
	@ManyToOne 
	@JoinColumn(name = "deta_id_factura")
	private Factura factura;
	
	@ManyToOne
	@JoinColumn(name = "deta_id_producto")
	private Producto producto;

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

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Integer getNumeroItems() {
		return numeroItems;
	}

	public void setNumeroItems(Integer numeroItems) {
		this.numeroItems = numeroItems;
	}

	@Override
	public String toString() {
		return "DetalleFactura [id=" + id + ", cantidad=" + cantidad + ", subtotal=" + subtotal + ", factura=" + factura
				+ ", producto=" + producto + "]";
	}
	
	

}
