package edu.ventas.entities;

import java.util.ArrayList;
import java.util.List;

public class Fila {
	
	private List<Butaca> butacas = new ArrayList();
	int numero;
	public List<Butaca> getButacas() {
		return butacas;
	}
	public void setButacas(List<Butaca> butacas) {
		this.butacas = butacas;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}

}
