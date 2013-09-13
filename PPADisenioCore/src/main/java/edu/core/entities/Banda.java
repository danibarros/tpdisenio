package edu.core.entities;

public class Banda {

	private String nombre;
	private int categoria;
	private int idBanda;

	public int getIdBanda() {
		return idBanda;
	}

	public void setIdBanda(int idBanda) {
		this.idBanda = idBanda;
	}

	public Banda(String nombre, int categoria) {
		this.nombre = nombre;
		this.categoria = categoria;
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
