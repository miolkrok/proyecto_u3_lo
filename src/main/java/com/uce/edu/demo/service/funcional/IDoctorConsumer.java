package com.uce.edu.demo.service.funcional;

@FunctionalInterface
public interface IDoctorConsumer<T> {

	public void accept(T arg1);
	
}
