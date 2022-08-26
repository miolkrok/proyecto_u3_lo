package com.uce.edu.demo.repository.deber;

import com.uce.edu.demo.repository.modelo.deber.Cliente;

public interface IClienteRepository {

	public void insertar(Cliente cliente);

	public Cliente buscar(String cedula);
}
