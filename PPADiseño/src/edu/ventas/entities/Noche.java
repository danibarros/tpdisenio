package edu.ventas.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Noche {

	private int numeroDeNoches;
	private Set<Banda> bandas = new HashSet<Banda>();
	private Date horaInicio = new Date();
    private List<Entrada> entrada = new ArrayList<Entrada>();
    private Estadio estadio;
    private Integer fecha;

	public Noche(Estadio estadio,int numeroDeNoches, Set<Banda> bandas, Date horaInicio) {
		this.estadio = estadio;
		this.bandas = bandas;
		this.numeroDeNoches = numeroDeNoches;
		this.horaInicio = horaInicio;
		this.fecha = 15092013; //DDMMAAAA Esto es nuevo
	}

	public Estadio getEstadio() {
		return estadio;
	}

	public void setEstadio(Estadio estadio) {
		this.estadio = estadio;
	}
	
	public Integer getFecha() { //Esto es nuevo
		return fecha;
	}
	
	public List<Entrada> getEntrada() {
		return entrada;
	}

	public void setEntrada(List<Entrada> entrada) {
		this.entrada = entrada;
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

	public int precioDeLaNoche() {
		switch (this.mayorCategoria()) {
		case 1:return 0;
		case 2: return 50;
		case 3: return 100;
		case 4: return 200;
		default:return -1;
		}
		
	}
}
