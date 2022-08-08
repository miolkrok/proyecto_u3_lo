package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.util.List;

import com.uce.edu.demo.repository.modelo.Factura;

public interface IFacturaService {

	public List<Factura> buscarFacturaInnerJoin(BigDecimal subtotal);

	public List<Factura> buscarFacturaOuterJoinLeft(BigDecimal subtotal);

	public List<Factura> buscarFacturaOuterJoinRight(BigDecimal subtotal);
	
	public List<Factura> buscarFacturaJoinWhere(BigDecimal subtotal);
	
	public List<Factura> buscarFacturaJoinFetch(BigDecimal subtotal);

}
