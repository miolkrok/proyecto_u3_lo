package com.uce.edu.demo.service.funcional;

public class DoctorFunctionImpl<String> implements IDoctorFunction<String, Integer>{

	@Override
	public String aplicar(Integer arg1) {
		// TODO Auto-generated method stub
		String valor = (String) arg1.toString();
		return valor;
	}

}
