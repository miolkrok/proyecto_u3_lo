package com.uce.edu.demo.service.deber;

import org.springframework.beans.factory.annotation.Autowired;

import com.uce.edu.demo.repository.deber.IClienteRepository;
import com.uce.edu.demo.repository.modelo.deber.Cliente;

public class ClienteServiceImpl implements IClienteService{

	@Autowired
	private IClienteRepository clienteRepository;

	@Override
	public void insertar(Cliente cliente) {
		this.clienteRepository.insertar(cliente);

	}
	
}
