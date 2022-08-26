package com.uce.edu.demo.service.deber;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.uce.edu.demo.repository.deber.IClienteRepository;
import com.uce.edu.demo.repository.deber.IFacturaRepository;
import com.uce.edu.demo.repository.deber.IProductoRepository;
import com.uce.edu.demo.repository.modelo.deber.Factura;
import com.uce.edu.demo.repository.modelo.deber.Cliente;
import com.uce.edu.demo.repository.modelo.deber.DetalleFactura;
import com.uce.edu.demo.repository.modelo.deber.Producto;

@Service
public class FacturaServiceImpl implements IFacturaService {

	@Autowired
	private IFacturaRepository facturaRepository;
	
	@Autowired
	private IProductoRepository productoRepository;
	
	@Autowired
	private IClienteRepository clienteRepository;

	@Override
	public List<Factura> buscarFacturaInnerJoin(BigDecimal subtotal) {
		
		// TODO Auto-generated method stub
//		return this.facturaRepository.buscarFacturaInnerJoin(subtotal);
		
		return null;
	}

	@Override
	public List<Factura> buscarFacturaOuterJoinLeft(BigDecimal subtotal) {
		return null;
		// TODO Auto-generated method stub
//		return this.facturaRepository.buscarFacturaOuterJoinLeft(subtotal);
	}

	@Override
	public List<Factura> buscarFacturaOuterJoinRight(BigDecimal subtotal) {
		return null;
		// TODO Auto-generated method stub
//		return this.facturaRepository.buscarFacturaOuterJoinRight(subtotal);
	}

	@Override
	public List<Factura> buscarFacturaJoinWhere(BigDecimal subtotal) {
		return null;
		// TODO Auto-generated method stub
//		return this.facturaRepository.buscarFacturaJoinWhere(subtotal);
	}

	@Override
	public List<Factura> buscarFacturaJoinFetch(BigDecimal subtotal) {
		return null;
		// TODO Auto-generated method stub
//		return this.facturaRepository.buscarFacturaJoinFetch(subtotal);
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public BigDecimal ingresarFactura(String cedula, String numero, List<String> codigo) {
		// TODO Auto-generated method stub
		
		BigDecimal totalPagar = BigDecimal.ZERO;
		
		Cliente cliente = this.clienteRepository.buscar(cedula);
		
		
		Factura fact = new Factura();
		fact.setCliente(cliente);
		fact.setFecha(LocalDateTime.now());
		fact.setNumero(numero);
		
		List<DetalleFactura> detalles = new ArrayList<>();

		for (String codigoBarras : codigo) {
			DetalleFactura deta = new DetalleFactura();
			deta.setCantidad(1);
			deta.setFactura(fact);
			Producto producto = this.productoRepository.buscar(codigoBarras);
			deta.setProducto(producto);
			deta.setSubtotal(deta.getProducto().getPrecio());
			totalPagar.add(deta.getSubtotal());
			producto.setStock(producto.getStock() - deta.getCantidad());
			this.productoRepository.actualizar(producto);
			detalles.add(deta);
			//this.detalleRepository.insertar(deta);

		}
		
		fact.setDetalleFactura(detalles);
		
		this.facturaRepository.insertar(fact);
		
		return totalPagar;
	}

}
