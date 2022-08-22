package com.uce.edu.demo.repository.deber;

import com.uce.edu.demo.repository.modelo.deber.Factura;

public interface IFacturaRepository {

	public void insertar(Factura factura);

	public Factura buscar(Integer id);

	public void actualizar(Factura factura);

}
