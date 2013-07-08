package edu.ventas.entities;

import java.util.ArrayList;
import java.util.List;

public class Estadio  extends CentroDeVenta{
	private List<Sector> sectores = new ArrayList<Sector>();
	
	public Estadio(List<Sector> sectores, List<PuntoDeVenta> puntosDeVenta){
		puntosDeVenta = this.puntosDeVenta;
		sectores = this.sectores;
	}
	
	public int vender(Entrada entrada,PuntoDeVenta puntoDeVenta){
		return 0;
	}

	public List<Sector> getSectores() {
		return sectores;
	}

	public void setSectores(List<Sector> sectores) {
		this.sectores = sectores;
	}
	

}
