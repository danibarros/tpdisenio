package edu.core.entities;

import java.util.ArrayList;
import java.util.List;

public class Pais {
	private Integer idPais;
	private String nombre;
	private List<Provincia> provincias ;
	
	public Pais(){
		this.provincias = new ArrayList<Provincia>();
	}
	
	public List<Provincia> getProvincias() {
		return provincias;
	}
	public void setProvincias(List<Provincia> provincias) {
		this.provincias = provincias;
	}
	public Integer getIdPais() {
		return idPais;
	}
	public void setIdPais(Integer idPais) {
		this.idPais = idPais;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
