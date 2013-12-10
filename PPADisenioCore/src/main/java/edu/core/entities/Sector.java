package edu.core.entities;

import java.util.ArrayList;
import java.util.List;

public class Sector {

	private int idSector;
	private List<Fila> filas ;
	private Double precioSector;
	private String color;
	
	public Sector(){
		this.filas = new ArrayList<Fila>();
	}
	
	public int getIdSector() {
		return idSector;
	}

	public void setIdSector(int idSector) {
		this.idSector = idSector;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public Sector(String color, List<Fila> filas, int precioSector) {
		this.filas = filas;
		this.precioSector = (double) precioSector;
		this.color = color;
	}

	public Double getPrecioSector() {

		return this.precioSector;
	}

	public void setPrecioSector(Double precioSector) {
		this.precioSector = precioSector;
	}

	public List<Fila> getFilas() {
		return this.filas;
	}

	public void setFilas(List<Fila> filas) {
		this.filas = filas;
	}

}
