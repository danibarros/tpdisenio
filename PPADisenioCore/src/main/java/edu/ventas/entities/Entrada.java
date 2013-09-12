package edu.ventas.entities;

import java.sql.Date;

public class Entrada {
	
	private Butaca butaca;
	
	private long codigoDeBarra;

	private Noche noche;
	
	private int numeroDeEntrada;
	
	private Date fecha;
	
	private float precio;
	
	private char tipo;
	
	private String clienteNombre;
	
	private int clienteDNI;
	
	private boolean anticipada;
	

	public boolean isAnticipada() {
		return anticipada;
	}


	public void setAnticipada(boolean anticipada) {
		this.anticipada = anticipada;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public float getPrecio() {
		return precio;
	}


	public void setPrecio(float precio) {
		this.precio = precio;
	}


	public char getTipo() {
		return tipo;
	}


	public void setTipo(char tipo) {
		this.tipo = tipo;
	}


	public String getClienteNombre() {
		return clienteNombre;
	}


	public void setClienteNombre(String clienteNombre) {
		this.clienteNombre = clienteNombre;
	}


	public int getClienteDNI() {
		return clienteDNI;
	}


	public void setClienteDNI(int clienteDNI) {
		this.clienteDNI = clienteDNI;
	}


	public int getNumeroDeEntrada() {
		return numeroDeEntrada;
	}


	public Entrada(int numeroDeEntrada, Butaca butaca, Noche noche) {
		this.numeroDeEntrada = numeroDeEntrada;
		this.butaca = butaca;
		
		this.noche = noche;
		this.codigoDeBarra=123123;
		
	}

	
	public int calcularPrecioBase(){
		return this.noche.precioDeLaNoche();
	}
	
	public int getNuemroDeEntrada(){
		return this.numeroDeEntrada;
	}
	

	public void setButaca(Butaca butaca) {
		this.butaca = butaca;
	}
	
	public Butaca getButaca() {
		return this.butaca;
	}

	public long getCodigoDeBarra() {
		return codigoDeBarra;
	}

	public void setCodigoDeBarra(long codigoDeBarra) {
		this.codigoDeBarra = codigoDeBarra;
	}

	
	public Noche getNoche() {
		return noche;
	}

	public void setNoche(Noche noche) {
		this.noche = noche;
	}

//	public int getNumeroDeEntrada() { Ya esta arriba
//		return numeroDeEntrada;
//	}

	public void setNumeroDeEntrada(int numeroDeEntrada) {
		this.numeroDeEntrada = numeroDeEntrada;
	}

	
}
