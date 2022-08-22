package com.uce.edu.demo.repository.deber;

import com.uce.edu.demo.repository.modelo.deber.DetalleFactura;

public interface IDetalleFacturaRepository {

	
	public void insertar(DetalleFactura detalleFactura);

	public DetalleFactura buscar(Integer id);

	public void actualizar(DetalleFactura detalleFactura);
}
