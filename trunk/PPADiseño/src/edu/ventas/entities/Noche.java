package edu.ventas.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Noche {

	private int numeroDeNoches;
	private Set<Banda> bandas = new HashSet<Banda>();
	private Date horaInicio = new Date();

	public Noche(int numeroDeNoches, Set<Banda> bandas, Date horaInicio) {
		this.bandas = bandas;
		this.numeroDeNoches = numeroDeNoches;
		this.horaInicio = horaInicio;
	}

	public int mayorCategoria() {
		int max = -1;
		for (Banda unaBanda : this.bandas) {

			if (max < unaBanda.getCategoria()) {

				max = unaBanda.getCategoria();
			}
		}
		return max;
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
}
