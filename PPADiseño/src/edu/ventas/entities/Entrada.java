package edu.ventas.entities;

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

	public Entrada(int numeroDeEntrada, Butaca butaca, Fila fila,
			Sector sector, long codigoDeBarra, Festival festival, Noche noche,
			Map<Integer, Integer> categorias) {
		this.numeroDeEntrada = numeroDeEntrada;
		this.butaca = butaca;
		this.fila = fila;
		this.sector = sector;
		this.codigoDeBarra = codigoDeBarra;
		this.festival = festival;
		this.noche = noche;
		this.precio = calcularPrecioBase() + calcularPrecioExtra(categorias);
	}

	public int calcularPrecioBase() {
		int precioBase = 0;
		precioBase = fila.getPrecioFila();
		precioBase = precioBase + sector.getPrecioSector();
		return precioBase;
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

	private int calcularPrecioExtra(Map<Integer, Integer> categorias) {
		return categorias.get(noche.mayorCategoria());
	}
}
