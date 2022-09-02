package com.uce.edu.demo.hilos.paralelo.deber;

import java.util.concurrent.TimeUnit;

public class PCImpresoraTresDParalelo extends Thread  {

	private ImpresoraTresDParalelo impresoraParalelo;

	public PCImpresoraTresDParalelo(ImpresoraTresDParalelo impresoraParalelo) {
		this.impresoraParalelo = impresoraParalelo;
	}

	// Disparar el metodo a paralelizar
	@Override
	public void run() {
		this.procesar(this.impresoraParalelo);
	}
	
	public void procesar(ImpresoraTresDParalelo impresoraParalelo) {
		long tiempoInicial = System.currentTimeMillis();
		System.out.println("Nombre Hilo procesar: " + Thread.currentThread().getName());
		System.out.println("Procesando impresora: " + impresoraParalelo.getNombreImpresora());
		for (String pieza : impresoraParalelo.getPiezas()) {
			this.imprimirPieza(pieza);
		}
		long tiempoFinal = System.currentTimeMillis();

		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;
		System.out.println("Termino: " + impresoraParalelo.getNombreImpresora() + " en:" + tiempoTranscurrido + " seg ");
	}
	
	private void imprimirPieza(String pieza) {
		System.out.println("imprimiendo: " + pieza);
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
