package edu.ventas.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class CentroDeVenta {
	private String nombre;
	protected List<PuntoDeVenta> puntosDeVenta = new ArrayList<PuntoDeVenta>();

	public int vender(Entrada entrada) {
		return 2;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<PuntoDeVenta> getPuntosDeVenta() {
		return puntosDeVenta;
	}

	public void setPuntosDeVenta(List<PuntoDeVenta> puntosDeVenta) {
		this.puntosDeVenta = puntosDeVenta;
	}

}
