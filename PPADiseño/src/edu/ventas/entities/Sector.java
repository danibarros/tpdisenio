package edu.ventas.entities;

import java.util.ArrayList;
import java.util.List;

public class Sector {
	
	private List<Fila> filas = new ArrayList();
	char nombre;
	public List<Fila> getFilas() {
		return filas;
	}
	public void setFilas(List<Fila> filas) {
		this.filas = filas;
	}
	public char getNombre() {
		return nombre;
	}
	public void setNombre(char nombre) {
		this.nombre = nombre;
	}

}
