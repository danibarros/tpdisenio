package edu.ventas.entities;

public class Butaca {
	private boolean disponible;
	private int numero;
	
	public Butaca(boolean disponible,int numero){
		disponible=this.disponible;
		numero=this.numero;
		
	}
	
	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
}
