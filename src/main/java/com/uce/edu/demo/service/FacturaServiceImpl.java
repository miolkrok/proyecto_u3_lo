package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IFacturaRepository;
import com.uce.edu.demo.repository.modelo.Factura;

@Service
public class FacturaServiceImpl implements IFacturaService {

	@Autowired
	private IFacturaRepository facturaRepository;

	@Override
	public List<Factura> buscarFacturaInnerJoin(BigDecimal subtotal) {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscarFacturaInnerJoin(subtotal);
	}

	@Override
	public List<Factura> buscarFacturaOuterJoinLeft(BigDecimal subtotal) {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscarFacturaOuterJoinLeft(subtotal);
	}

	@Override
	public List<Factura> buscarFacturaOuterJoinRight(BigDecimal subtotal) {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscarFacturaOuterJoinRight(subtotal);
	}

	@Override
	public List<Factura> buscarFacturaJoinWhere(BigDecimal subtotal) {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscarFacturaJoinWhere(subtotal);
	}

	@Override
	public List<Factura> buscarFacturaJoinFetch(BigDecimal subtotal) {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscarFacturaJoinFetch(subtotal);
	}

}
