package edu.core.entities;

import java.util.ArrayList;
import java.util.List;

public class PuntoDeVenta extends CentroDeVenta {

	private int idPunto;
	private Festival festival;
	protected List<Entrada> Entradas = new ArrayList<Entrada>();
	private Localidad localidad;
	private String nombre;
	private String direccion;
	
	public int getIdPunto() {
		return idPunto;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	public void setIdPunto(int idPunto) {
		this.idPunto = idPunto;
	}

	public Festival getFestival() {
		return festival;
	}

	public void setFestival(Festival festival) {
		this.festival = festival;
	}

	public List<Entrada> getEntradas() {
		return Entradas;
	}

	public void setEntradas(List<Entrada> entradas) {
		Entradas = entradas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public int vender(Entrada entrada) {
		System.out.println("entrada vendida");
		return 3;
	}

}
