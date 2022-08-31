package com.uce.edu.demo.hilos.paralelo;

import java.util.concurrent.TimeUnit;

public class PCCajeroParalelo extends Thread {

	private CajeroParalelo cajeroParalelo;

	public PCCajeroParalelo(CajeroParalelo cajeroParalelo) {
		this.cajeroParalelo = cajeroParalelo;
	}

	// Disparar el metodo a paralelizar
	@Override
	public void run() {
		this.procesar(this.cajeroParalelo);
	}

	public void procesar(CajeroParalelo cajeroParalelo) {
		long tiempoInicial = System.currentTimeMillis();
		System.out.println("Nombre Hilo procesar: " + Thread.currentThread().getName());
		System.out.println("Procesando cajero: " + cajeroParalelo.getNombre());
		for (String cliente : cajeroParalelo.getClientes()) {
			this.atenderCliente(cliente);
		}
		long tiempoFinal = System.currentTimeMillis();

		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;
		System.out.println("Termino: " + cajeroParalelo.getNombre() + " en:" + tiempoTranscurrido + " seg ");
	}

	private void atenderCliente(String cliente) {
		System.out.println("Atendiendo a: " + cliente);
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
