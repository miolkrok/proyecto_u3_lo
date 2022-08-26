package com.uce.edu.demo.service.funcional;

public class DoctorFunctionUnaryOperatorImpl implements IDoctorFunctionUnaryOperator<String> {

	@Override
	public String aplicar(String arg1) {
		// TODO Auto-generated method stub
		String cadena = arg1.concat("UnaryOperator Listo");
		return cadena;
	}

}
