package com.uce.edu.demo.repository;

import java.math.BigDecimal;
import java.util.List;

import com.uce.edu.demo.repository.modelo.Factura;

public interface IFacturaRepository {

	public List<Factura> buscarFacturaInnerJoin(BigDecimal subtotal);

	public List<Factura> buscarFacturaOuterJoinLeft(BigDecimal subtotal);

	public List<Factura> buscarFacturaOuterJoinRight(BigDecimal subtotal);
}
