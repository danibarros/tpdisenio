package edu.ventas.entities;

import java.util.ArrayList;
import java.util.List;

public class Sector {

	private String nombre;
	private List<Fila> filas = new ArrayList<Fila>();
	private int precioSector;
	private char ubicacion;

	public Sector(String nombre, List<Fila> filas, int precioSector,
			char ubicacion) {
		this.nombre = nombre;
		this.filas = filas;
		this.precioSector = precioSector;
		this.ubicacion = ubicacion;
	}

	public char getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(char ubicacion) {
		ubicacion = this.ubicacion;
	}

	public int getPrecioSector() {

		return this.precioSector;
	}

	public void setPrecioSector(int precioSector) {
		this.precioSector = precioSector;
	}

	public List<Fila> getFilas() {
		return this.filas;
	}

	public void setFilas(List<Fila> filas) {
		this.filas = filas;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
