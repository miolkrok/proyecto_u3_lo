package com.uce.edu.demo.service.funcional;

public class DoctorMetodosHighOrder {

	public String consumirSupplier(IDoctorSupplier<String> funcion) {

		return funcion.getNombre() + " Consumer HO";
	}

	public void consumirConsumer(IDoctorConsumer<Integer> funcion, Integer valor) {
		funcion.accept(valor);

	}

	public boolean consumirPredicate(IDoctorPredicate<String> funcion, String valor) {
		return funcion.evaluar(valor);
	}

	public String consumirFunction(IDoctorFunction<String, Integer> funcion, Integer valor) {
		return funcion.aplicar(valor) + " Function HO";
	}
	
}
