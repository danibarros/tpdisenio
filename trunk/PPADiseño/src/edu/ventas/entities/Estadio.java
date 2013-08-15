package edu.ventas.entities;

import java.util.ArrayList;
import java.util.List;

public class Estadio extends CentroDeVenta {

	private static List<Sector> sectores = new ArrayList<Sector>();
	private String nombre;

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
