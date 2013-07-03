package edu.ventas.entities;

import java.util.ArrayList;
import java.util.List;

public class Sector {
	
	char nombre;
	private List<Fila> filas = new ArrayList<Fila>();
	
	public Sector(char nombre,List<Fila> filas){
		nombre=this.nombre;
		filas=this.filas;
	}
	
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
