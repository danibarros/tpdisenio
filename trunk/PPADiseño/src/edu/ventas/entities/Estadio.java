package edu.ventas.entities;

import java.util.ArrayList;
import java.util.List;

public class Estadio {
	private List<Sector> sectores = new ArrayList<Sector>();
	
	public int vender(Entrada entrada){
		return 1;
	}

	public List<Sector> getSectores() {
		return sectores;
	}

	public void setSectores(List<Sector> sectores) {
		this.sectores = sectores;
	}
	

}
