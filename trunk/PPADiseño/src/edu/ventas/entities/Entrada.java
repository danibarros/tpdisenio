package edu.ventas.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Entrada {
	private Butaca butaca;
	private int precio;
	private long codigoDeBarra;
	private Festival festival;
	private Noche noche;
	private int numeroDeEntrada;
	private Fila fila;
	private Sector sector;
	
	public Entrada(int numeroDeEntrada, Butaca butaca, Fila fila, Sector sector,
			long codigoDeBarra, Festival festival, Noche noche, Map <String,Integer> categorias){
		numeroDeEntrada = this.numeroDeEntrada;
		butaca = this.butaca;
		fila = this.fila;
		sector = this.sector;
		codigoDeBarra = this.codigoDeBarra;
		festival = this.festival;
		noche = this.noche;
		precio = calcularPrecioBase() + calcularPrecioExtra(categorias);
	}

	
	
	
	private int calcularPrecioExtra(Map <String,Integer> categorias ){
		
		return categorias.get(noche.mayorCategoria());
	}
	
	public int calcularPrecioBase(){
		return fila.getPrecioFila() + sector.getPrecioSector();
	}
	
	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public Fila getFila() {
		return fila;
	}
	public void setFila(Fila fila) {
		this.fila = fila;
	}
	public Sector getSector() {
		return sector;
	}
	public void setSector(Sector sector) {
		this.sector = sector;
	}
	public Butaca getButaca() {
		return butaca;
	}
	public void setButaca(Butaca butaca) {
		this.butaca = butaca;
	}
	public long getCodigoDeBarra() {
		return codigoDeBarra;
	}
	public void setCodigoDeBarra(long codigoDeBarra) {
		this.codigoDeBarra = codigoDeBarra;
	}
	public Festival getFestival() {
		return festival;
	}
	public void setFestival(Festival festival) {
		this.festival = festival;
	}
	public Noche getNoche() {
		return noche;
	}
	public void setNoche(Noche noche) {
		this.noche = noche;
	}
	public int getNumeroDeEntrada() {
		return numeroDeEntrada;
	}
	public void setNumeroDeEntrada(int numeroDeEntrada) {
		this.numeroDeEntrada = numeroDeEntrada;
	}

}
