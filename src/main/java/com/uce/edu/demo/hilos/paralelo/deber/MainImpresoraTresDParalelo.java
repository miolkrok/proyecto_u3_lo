package com.uce.edu.demo.hilos.paralelo.deber;

import java.util.Arrays;

public class MainImpresoraTresDParalelo {

	public static void main(String[] args) {

		long tiempoInicial = System.currentTimeMillis();

		System.out.println("Nombre Hilo: " + Thread.currentThread().getName());

		ImpresoraTresDParalelo impresora1 = new ImpresoraTresDParalelo("XEON",
				Arrays.asList("Cabeza", "Brazo", "Pierna", "Torzo"));
		ImpresoraTresDParalelo impresora2 = new ImpresoraTresDParalelo("CANON",
				Arrays.asList("Cabeza2", "Brazo2", "Pierna2", "Torzo2"));
		ImpresoraTresDParalelo impresora3 = new ImpresoraTresDParalelo("HP",
				Arrays.asList("Cabeza3", "Brazo3", "Pierna3", "Torzo3"));
		ImpresoraTresDParalelo impresora4 = new ImpresoraTresDParalelo("EPSON",
				Arrays.asList("Cabeza4", "Brazo4", "Pierna4", "Torzo4"));
		ImpresoraTresDParalelo impresora5 = new ImpresoraTresDParalelo("SNAPMAKER",
				Arrays.asList("Cabeza5", "Brazo5", "Pierna5", "Torzo5"));

		PCImpresoraTresDParalelo gestorImpresion = new PCImpresoraTresDParalelo(impresora1);
		gestorImpresion.start();

		PCImpresoraTresDParalelo gestorImpresion2 = new PCImpresoraTresDParalelo(impresora2);
		gestorImpresion2.start();

		PCImpresoraTresDParalelo gestorImpresion3 = new PCImpresoraTresDParalelo(impresora3);
		gestorImpresion3.start();

		PCImpresoraTresDParalelo gestorImpresion4 = new PCImpresoraTresDParalelo(impresora4);
		gestorImpresion4.start();

		PCImpresoraTresDParalelo gestorImpresion5 = new PCImpresoraTresDParalelo(impresora5);
		gestorImpresion5.start();

		long tiempoFinal = System.currentTimeMillis();

		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;
		System.out.println(tiempoTranscurrido + " seg ");
	}
}
