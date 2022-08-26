package com.uce.edu.demo.repository.deber;

import com.uce.edu.demo.repository.modelo.deber.Producto;

public interface IProductoRepository {

	public void insertar(Producto producto);

	public void actualizar(Producto producto);

	public Producto buscar(String codigoBarras);
	
}
