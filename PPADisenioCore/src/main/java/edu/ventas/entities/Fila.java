package edu.ventas.entities;

import java.util.ArrayList;
import java.util.List;

public class Fila {

	private int idFila;
	private int numero;
	private List<Butaca> butacas = new ArrayList<Butaca>();
	private int precioFila;
	private Sector sector;

	public Fila(int numero, List<Butaca> butacas) {
		this.numero = numero;
		this.butacas = butacas;
		this.setPrecioFila(numero);
	}

	public int getPrecioFila() {
		return this.precioFila;
	}

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

	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}
	
	private void setPrecioFila(int precioFila) {
		precioFila = 300 / numero;
		this.precioFila = precioFila;
	}
}
