package com.uce.edu.demo.hilos.tradicional;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		long tiempoInicial = System.currentTimeMillis();
		
		Cajero cajero1 = new Cajero("Luis", Arrays.asList("Pepito", "Juan", "Daniel", "Pablo"));
		Cajero cajero2 = new Cajero("Fernanda", Arrays.asList("Pepito2", "Juan2", "Daniel2", "Pablo2"));
		Cajero cajero3 = new Cajero("Miguel", Arrays.asList("Pepito3", "Juan3", "Daniel3", "Pablo3"));
		
		PCCajero gestorAtencion = new PCCajero();
		
		gestorAtencion.procesar(cajero1);
		gestorAtencion.procesar(cajero2);
		gestorAtencion.procesar(cajero3);
		
		long tiempoFinal = System.currentTimeMillis();
		
		long tiempoTranscurrido = (tiempoFinal-tiempoInicial)/1000;
		System.out.println(tiempoTranscurrido + " seg ");
	}

}
