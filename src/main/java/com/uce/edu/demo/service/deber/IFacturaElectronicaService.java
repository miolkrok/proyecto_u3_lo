package com.uce.edu.demo.service.deber;

import java.math.BigDecimal;

public interface IFacturaElectronicaService {

	public void procesarElectronica(String numero, BigDecimal monto, Integer numeroItems);
	
}
