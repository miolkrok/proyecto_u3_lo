package com.uce.edu.demo.repository.deber;

import java.util.List;

import com.uce.edu.demo.repository.modelo.deber.Factura;
import com.uce.edu.demo.repository.modelo.deber.FacturaElectronicaTO;

public interface IFacturaRepository {

	public void insertar(Factura factura);

	public Factura buscar(Integer id);

	public void actualizar(Factura factura);
	
	public List<FacturaElectronicaTO> buscarPorNumeroFacturaElectronicaTO(String numero);

}
