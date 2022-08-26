package com.uce.edu.demo.service.deber;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.deber.IFacturaElectronicaRepository;
import com.uce.edu.demo.repository.modelo.deber.FacturaElectronica;

@Service
public class FacturaElectronicaServiceImpl implements IFacturaElectronicaService{

	@Autowired
	private IFacturaElectronicaRepository electronicaRepository;
	
	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void procesarElectronica(String numero, BigDecimal monto, Integer numeroItems) {
		// TODO Auto-generated method stub
		FacturaElectronica factElect = new FacturaElectronica();
		factElect.setNumero(numero);
		factElect.setFecha(LocalDateTime.now());
		factElect.setMonto(monto);
		factElect.setNumeroItem(numeroItems);
		this.electronicaRepository.insertar(factElect);
		throw new RuntimeException();
	}

}
