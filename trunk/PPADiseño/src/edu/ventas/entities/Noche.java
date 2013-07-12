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
	
	public Noche(int numeroDeNoches,Set<Banda> bandas,Date horaInicio){
		bandas=this.bandas;
		numeroDeNoches=this.numeroDeNoches;
		horaInicio=this.horaInicio;
	}
	
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
	
	public String mayorCategoria(){
		int max = -1;
		String laBanda = " ";
		
		for (Banda unaBanda: bandas) {
			
			if (max < unaBanda.getCategoria()) {
				
				max=unaBanda.getCategoria();
				laBanda=unaBanda.getNombre();
			}

		}
		return laBanda;
	}
	
}
