package edu.core.entities;

import java.util.ArrayList;
import java.util.List;

public class Localidad {

	private Integer idLocalidad;
	protected Provincia provincia ;
	private String nombre;
	private List<Estadio> estadios ;
	private List<PuntoDeVenta> puntosDeVenta;
	
	public Integer getIdLocalidad() {
		return idLocalidad;
	}
	public void setIdLocalidad(Integer idLocalidad) {
		this.idLocalidad = idLocalidad;
	}
	
	public List<PuntoDeVenta> getPuntosDeVenta() {
		return puntosDeVenta;
	}

	public void setPuntosDeVenta(List<PuntoDeVenta> puntosDeVenta) {
		this.puntosDeVenta = puntosDeVenta;
	}

	public Localidad(){
		this.estadios = new ArrayList<Estadio>();
		this.puntosDeVenta = new ArrayList<PuntoDeVenta>();
	}
	
	public List<Estadio> getEstadios() {
		return estadios;
	}
	public void setEstadios(List<Estadio> estadios) {
		this.estadios = estadios;
	}
	
	public Provincia getProvincia() {
		return provincia;
	}
	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
