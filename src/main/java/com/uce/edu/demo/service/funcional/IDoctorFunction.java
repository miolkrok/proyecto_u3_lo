package com.uce.edu.demo.service.funcional;

@FunctionalInterface
public interface IDoctorFunction<R,T> {

	public R aplicar(T arg1);
	
}
