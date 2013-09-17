package edu.core.entities;

import java.util.ArrayList;
import java.util.List;

public class Pais {
	private int idPais;
	private String nombre;
	private List<Provincia> provincias = new ArrayList<Provincia>();
	
	public List<Provincia> getProvincias() {
		return provincias;
	}
	public void setProvincias(List<Provincia> provincias) {
		this.provincias = provincias;
	}
	public int getIdPais() {
		return idPais;
	}
	public void setIdPais(int idPais) {
		this.idPais = idPais;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
