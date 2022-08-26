package com.uce.edu.demo.service.deber;

import java.util.List;

public interface IGestorCompraProductosService {

	public void registrarCompraProducto(String cedula, String numeroFactura, List<String> listaCodigo);

}
