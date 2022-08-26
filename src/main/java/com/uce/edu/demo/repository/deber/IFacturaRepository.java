package com.uce.edu.demo.repository.deber;

import java.math.BigDecimal;
import java.util.List;

import com.uce.edu.demo.repository.modelo.deber.Factura;
import com.uce.edu.demo.repository.modelo.deber.FacturaElectronica;

public interface IFacturaRepository {

	public List<Factura> buscarFacturaInnerJoin(BigDecimal subtotal);

	public List<Factura> buscarFacturaOuterJoinLeft(BigDecimal subtotal);

	public List<Factura> buscarFacturaOuterJoinRight(BigDecimal subtotal);
	
	public List<Factura> buscarFacturaJoinWhere(BigDecimal subtotal);
	
	public List<Factura> buscarFacturaJoinFetch(BigDecimal subtotal);
	
	public void insertar(Factura factura);

	public Factura buscar(Integer id);

	public void actualizar(Factura factura);
	
	public List<FacturaElectronica> buscarPorNumeroFacturaElectronicaTO(String numero);
}
