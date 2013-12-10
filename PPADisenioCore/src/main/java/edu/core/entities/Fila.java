package edu.core.entities;

import java.util.ArrayList;
import java.util.List;

public class Fila {

	private int idFila;
	private int numero;
	private List<Butaca> butacas ;
	private Double precioFila;
	private Sector sector;
	
	public Fila(){
		this.butacas = new ArrayList<Butaca>();
	}

	public Fila(int numero, List<Butaca> butacas) {
		this.numero = numero;
		this.butacas = butacas;
		this.setPrecioFila((double) numero);
	}

	public int getIdFila() {
		return idFila;
	}

	public void setIdFila(int idFila) {
		this.idFila = idFila;
	}

	public Double getPrecioFila() {
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
	
	private void setPrecioFila(Double precioFila) {
		this.precioFila = precioFila / numero;
	}
}
