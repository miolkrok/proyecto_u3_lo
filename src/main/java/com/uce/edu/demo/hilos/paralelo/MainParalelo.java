package com.uce.edu.demo.hilos.paralelo;

import java.util.Arrays;

public class MainParalelo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long tiempoInicial = System.currentTimeMillis();

		System.out.println("Nombre Hilo: " + Thread.currentThread().getName());
		CajeroParalelo cajero1 = new CajeroParalelo("Luis", Arrays.asList("Pepito"));
		CajeroParalelo cajero2 = new CajeroParalelo("Fernanda", Arrays.asList("Pepito2"));
		CajeroParalelo cajero3 = new CajeroParalelo("Miguel", Arrays.asList("Pepito3"));

		CajeroParalelo cajero4 = new CajeroParalelo("Luis", Arrays.asList( "Juan"));
		CajeroParalelo cajero5 = new CajeroParalelo("Fernanda", Arrays.asList( "Juan2"));
		CajeroParalelo cajero6 = new CajeroParalelo("Miguel", Arrays.asList("Juan3"));
		
		
		PCCajeroParalelo gestorAtencion = new PCCajeroParalelo(cajero1);
		gestorAtencion.start();

		PCCajeroParalelo gestorAtencion2 = new PCCajeroParalelo(cajero2);
		gestorAtencion2.start();

		PCCajeroParalelo gestorAtencion3 = new PCCajeroParalelo(cajero3);
		gestorAtencion3.start();
		
		PCCajeroParalelo gestorAtencion4 = new PCCajeroParalelo(cajero4);
		gestorAtencion4.start();

		PCCajeroParalelo gestorAtencion5 = new PCCajeroParalelo(cajero5);
		gestorAtencion5.start();

		PCCajeroParalelo gestorAtencion6 = new PCCajeroParalelo(cajero6);
		gestorAtencion6.start();
		//
//		for(int i =0; i<100; i++) {
//			PCCajeroParalelo gestorAtencion6 = new PCCajeroParalelo(cajero6);
//			gestorAtencion6.start();
//		}
		long tiempoFinal = System.currentTimeMillis();

		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;
		System.out.println(tiempoTranscurrido + " seg ");

	}

}
