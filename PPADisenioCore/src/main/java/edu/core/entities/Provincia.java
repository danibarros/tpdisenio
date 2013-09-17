package edu.core.entities;

import java.util.ArrayList;
import java.util.List;

public class Provincia {
	private Integer idProvincia ;
	private String nombre ;
	private Pais pais;
	private List<Localidad> localidades = new ArrayList<Localidad>();

	public List<Localidad> getLocalidades() {
		return localidades;
	}
	public void setLocalidades(List<Localidad> localidades) {
		this.localidades = localidades;
	}
	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	public Integer getIdProvincia() {
		return idProvincia;
	}
	public void setIdProvincia(Integer idProvincia) {
		this.idProvincia = idProvincia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
