package com.uce.edu.demo.service.deber;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.deber.IFacturaRepository;
import com.uce.edu.demo.repository.modelo.deber.FacturaElectronicaTO;

@Service
public class FacturaServiceImpl implements IFacturaService{

	@Autowired
	private IFacturaRepository facturaRepository;
	
	@Override
	public void crearFacturaElectronica(FacturaElectronicaTO facturaElectronicaTO) {
		// TODO Auto-generated method stub
		
	}

}
