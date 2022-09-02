package com.uce.edu.demo.hilos.paralelo.deber;

import java.util.List;

public class ImpresoraTresDParalelo {

	private String nombreImpresora;

	private List<String> piezas;

	public ImpresoraTresDParalelo(String nombreImpresora, List<String> piezas) {
		super();
		this.nombreImpresora = nombreImpresora;
		this.piezas = piezas;
	}

	//Set y Get
	public String getNombreImpresora() {
		return nombreImpresora;
	}

	public void setNombreImpresora(String nombreImpresora) {
		this.nombreImpresora = nombreImpresora;
	}

	public List<String> getPiezas() {
		return piezas;
	}

	public void setPiezas(List<String> piezas) {
		this.piezas = piezas;
	}

	@Override
	public String toString() {
		return "Impresora3DParalelo [nombreImpresora=" + nombreImpresora + ", piezas=" + piezas + "]";
	}
	

}
