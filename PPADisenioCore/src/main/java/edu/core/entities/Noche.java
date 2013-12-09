package edu.core.entities;

import java.sql.Time;
import java.util.ArrayList;
import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Noche {

	private int idNoche;
	private List<Banda> bandas;
	private Time horaInicio;
    private Date fecha;
    private int numero;
    
    public Noche(){
    	
    	this.bandas = new ArrayList<Banda>();
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

	public Noche(int numeroDeNoches, List<Banda> bandas, Time horaInicio) {
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

	public List<Banda> getBandas() {
		return bandas;
	}

	public void setBandas(List<Banda> bandas) {
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
