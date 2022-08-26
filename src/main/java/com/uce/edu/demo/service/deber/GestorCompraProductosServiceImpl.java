package com.uce.edu.demo.service.deber;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GestorCompraProductosServiceImpl implements IGestorCompraProductosService{

	@Autowired
	private IFacturaService facturaService;
	
	@Autowired
	private IFacturaElectronicaService facturaElectronicaService;
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void registrarCompraProducto(String cedula, String numeroFactura, List<String> listaCodigo) {
		// TODO Auto-generated method stub
		BigDecimal valorTotal = this.facturaService.ingresarFactura(cedula, numeroFactura, listaCodigo);
		
		this.facturaElectronicaService.procesarElectronica(numeroFactura, valorTotal, listaCodigo.size());
	}

}
