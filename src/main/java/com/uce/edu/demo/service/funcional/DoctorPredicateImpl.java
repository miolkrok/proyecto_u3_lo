package com.uce.edu.demo.service.funcional;

public class DoctorPredicateImpl implements IDoctorPredicate<String>{

	@Override
	public boolean evaluar(String arg1) {
		// TODO Auto-generated method stub
		if(arg1.equalsIgnoreCase("i")) {
			System.out.println("verdadero");
			return true;
		}else {
			System.out.println("falso");
			return false;
		}
	}

}
