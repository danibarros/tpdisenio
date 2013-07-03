package edu.ventas.entities;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Noche {

	private int numeroDeNoches;
	private Set<Banda> bandas = new HashSet<Banda>();
	private Date horaInicio = new Date();
	public Map<Integer, Integer> getCategorias() {
		return categorias;
	}
	public void setCategorias(Map<Integer, Integer> categorias) {
		this.categorias = categorias;
	}
	private Map<Integer,Integer> categorias = new HashMap<Integer,Integer>();
	
	public int getNumeroDeNoches() {
		return numeroDeNoches;
	}
	public void setNumeroDeNoches(int numeroDeNoches) {
		this.numeroDeNoches = numeroDeNoches;
	}
	public Set<Banda> getBandas() {
		return bandas;
	}
	public void setBandas(Set<Banda> bandas) {
		this.bandas = bandas;
	}
	public Date getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}
	
}
