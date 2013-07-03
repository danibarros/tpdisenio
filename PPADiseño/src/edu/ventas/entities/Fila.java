package edu.ventas.entities;

import java.util.ArrayList;
import java.util.List;

public class Fila {
	
	int numero;
	private List<Butaca> butacas = new ArrayList<Butaca>();
	
	public Fila(int numero,List<Butaca> butacas){
		numero=this.numero;
		butacas=this.butacas;
		
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

}
