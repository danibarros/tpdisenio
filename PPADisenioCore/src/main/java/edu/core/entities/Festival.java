package edu.core.entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Festival {

	private String nombre;
	private Estadio estadio;
	private List<Noche> noches ;
	private int idFestival;
	private Date fechaInicio;
	
	public Festival(){
		this.noches = new ArrayList<Noche>();
	}
	
	public int getIdFestival() {
		return idFestival;
	}

	public void setIdFestival(int idFestival) {
		this.idFestival = idFestival;
	}

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

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

}
