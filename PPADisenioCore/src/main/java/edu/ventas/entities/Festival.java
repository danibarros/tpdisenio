package edu.ventas.entities;

import java.util.ArrayList;
import java.util.List;

public class Festival {

	private String nombre;
	private Estadio estadio;
	private List<Noche> noches = new ArrayList<Noche>();

	public Festival(String nombre, Estadio estadio, List<Noche> noches) {
		this.nombre = nombre;
		this.estadio = estadio;
		this.noches = noches;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Estadio getEstadio() {
		return estadio;
	}

	public void setEstadio(Estadio estadio) {
		this.estadio = estadio;
	}

	public List<Noche> getNoches() {
		return noches;
	}

	public void setNoches(List<Noche> noches) {
		this.noches = noches;
	}

}
