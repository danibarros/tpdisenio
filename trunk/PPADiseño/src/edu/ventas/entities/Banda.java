package edu.ventas.entities;

public class Banda {

	private String nombre;
	private int categoria;

	public Banda(String nombre,int categoria){
		nombre=this.nombre;
		categoria=this.categoria;
		
	}
	
	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
