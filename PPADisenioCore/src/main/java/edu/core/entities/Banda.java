package edu.core.entities;

public class Banda {

	private String nombre;
	private Categoria categoria;
	private int idBanda;

	public int getIdBanda() {
		return idBanda;
	}

	public void setIdBanda(int idBanda) {
		this.idBanda = idBanda;
	}
	
	public Banda(){
		
	}

	public Banda(String nombre, Categoria categoria) {
		this.nombre = nombre;
		this.categoria = categoria;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
