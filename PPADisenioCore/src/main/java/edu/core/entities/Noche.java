package edu.core.entities;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Noche {

	private int idNoche;
	private Set<Banda> bandas;
	private Time horaInicio;
    private List<Entrada> entradas;
    private Estadio estadio;
    private Festival festival;
    private Date fecha;
    private int numero;
    
    public Noche(){
    	this.entradas  = new ArrayList<Entrada>();
    	this.bandas = new HashSet<Banda>();
    }
    
	public Festival getFestival() {
		return festival;
	}

	public void setFestival(Festival festival) {
		this.festival = festival;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setHoraInicio(Time horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Noche(Estadio estadio,int numeroDeNoches, Set<Banda> bandas, Time horaInicio) {
		this.estadio = estadio;
		this.bandas = bandas;
		this.idNoche = numeroDeNoches;
		this.horaInicio = horaInicio;
		//this.fecha  //DDMMAAAA Esto es nuevo 
		/*1. si la fecha por "casualidad" la definis como Integer CONVIENE usar este formato YYYYMMDD.
		 * 2. es una fecha y existe el tipo de dato Date.
		 * 3. horaInicio es la fecha!
		 * fin del comunicado
		 * */
	}

	public Estadio getEstadio() {
		return estadio;
	}

	public void setEstadio(Estadio estadio) {
		this.estadio = estadio;
	}
	
	
	public List<Entrada> getEntradas() {
		return entradas;
	}

	public void setEntradas(List<Entrada> entradas) {
		this.entradas = entradas;
	}

	public int mayorCategoria() {
		int max = -1;
		for (Banda unaBanda : this.bandas) {
			if (max < unaBanda.getCategoria().getIdCategoria()) {
				max = unaBanda.getCategoria().getIdCategoria();
			}
		}
		return max;
	}

	public int getIdNoche() {
		return idNoche;
	}

	public void setIdNoche(int idNoche) {
		this.idNoche = idNoche;
	}

	public Set<Banda> getBandas() {
		return bandas;
	}

	public void setBandas(Set<Banda> bandas) {
		this.bandas = bandas;
	}

	public Time getHoraInicio() {
		return horaInicio;
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
