package edu.ventas.entities;

import java.util.ArrayList;
import java.util.List;

public class Estadio extends CentroDeVenta {

	private static List<Sector> sectores = new ArrayList<Sector>();
	private String nombre;
	private int IdEstadio;
	private Localidad localidad;

	public int getIdEstadio() {
		return IdEstadio;
	}

	public void setIdEstadio(int idEstadio) {
		IdEstadio = idEstadio;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	public Estadio(String nombre,List<Sector> sectores, List<PuntoDeVenta> puntosDeVenta) {
		this.nombre = nombre;
		this.puntosDeVenta = puntosDeVenta;
		this.sectores = sectores;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int vender(Entrada entrada, PuntoDeVenta puntoDeVenta) {
		return 0;
	}

	public static List<Sector> getSectores() {
		return sectores;
	}

	public void setSectores(List<Sector> sectores) {
		this.sectores = sectores;
	}

}
