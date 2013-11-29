package edu.core.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.core.dao.ButacaDAO;
import edu.core.dao.NocheDAO;

public class Entrada {
	
	private Butaca butaca;	
	private int codigoDeBarra;
	private Noche noche;
	private int numeroDeEntrada;
	private Date fecha;
	private float precio;
	private String tipo;
	private String clienteNombre;
	private boolean anticipada;
	private double precioFinal;
	private NocheDAO nocheDao;
	
	public boolean isAnticipada() {
		return anticipada;
	}

	public Entrada(){
		
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


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getClienteNombre() {
		return clienteNombre;
	}


	public void setClienteNombre(String clienteNombre) {
		this.clienteNombre = clienteNombre;
	}



	public int getNumeroDeEntrada() {
		return numeroDeEntrada;
	}


	public Entrada( Butaca butaca, Noche noche, NocheDAO nocheDao) {
		this.nocheDao = nocheDao;
		setButaca(butaca);
		setNoche(noche);
		setCodigoDeBarra(generarCodigo());
		
	}

	
	public Double calcularPrecioBase(){
		
		ButacaDAO butacaDao = new ButacaDAO();

				
		return butacaDao.getPrecioById(this.butaca.getIdButaca());
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

	public int getCodigoDeBarra() {
		return codigoDeBarra;
	}

	public void setCodigoDeBarra(int codigoDeBarra) {
		this.codigoDeBarra = codigoDeBarra;
	}

	
	public Noche getNoche() {
		return noche;
	}

	public void setNoche(Noche noche) {
		this.noche = noche;
	}


	public void setNumeroDeEntrada(int numeroDeEntrada) {
		this.numeroDeEntrada = numeroDeEntrada;
	}

	

	private int generarCodigo() {
		int numero = (int) Math.floor(Math.random() * (1 - 10000 + 1) + 10000);
		return numero;
	}
	
	
	
	public Double calcularPrecio(){ 
		
		Date fechaActual = new Date();
				
		double pBase,pNoche=0.0;
		
		setTipo("Adulto");
		pBase=calcularPrecioBase(); 
		pNoche=nocheDao.getPrecioNocheById(noche.getIdNoche());
		this.precioFinal = pBase + pNoche;
//		List<Noche> noches = new ArrayList<Noche>();
//		
//		for (Noche noche : noches) {
//			noche.equals(noche)
//		}
		if (noche.getHoraInicio().getTime()- fechaActual.getTime() > 30 / (24 * 60 * 60 * 1000))
			{
				this.precioFinal = precioFinal - 100;
				setAnticipada(true);
			
			}
		return precioFinal;
	}
	
	public Double calcularPrecioJubilados() {
		Date fechaActual = new Date();
		
		
		double pBase,pNoche=0.0;
		
		setTipo("Jubilado");
		
		pBase=calcularPrecioBase(); 
		System.out.println("PRECIO BASE: "+pBase);
		pNoche=nocheDao.getPrecioNocheById(noche.getIdNoche());
		System.out.println("PRECIO NOCHE: "+pNoche);
		this.precioFinal = pBase + pNoche - (pBase / 15);
			
		if (noche.getHoraInicio().getTime()- fechaActual.getTime() > 30 / (24 * 60 * 60 * 1000))
			this.precioFinal = precioFinal - 100; 
		return precioFinal;
		
	}

	public Double calcularPrecioMenores() {
		Date fechaActual = new Date();
		
		
		double pBase,pNoche=0.0;
		
		setTipo("Menor");
		
		pBase=calcularPrecioBase(); 
		pNoche=nocheDao.getPrecioNocheById(noche.getIdNoche());
		this.precioFinal = pBase + pNoche - descuentitoMenores(pBase);
			
		if (noche.getHoraInicio().getTime()- fechaActual.getTime() > 30 / (24 * 60 * 60 * 1000))
			this.precioFinal = precioFinal - 100; 
		return precioFinal;
		
	}
	
	

	private Double descuentitoMenores(Double base) {
		// TODO Auto-generated method stub
		Double descuento;
		if (base > 100)
		{
			descuento=base/20.0;
		}
		else if (base >50)
		{
			descuento=100.0;
		}
		else
		{
			descuento=0.0;
		}
		return descuento;
	}

	public double getPrecioFinal() {
		return precioFinal;
	}

	public void setPrecioFinal(double precioFinal) {
		this.precioFinal = precioFinal;
	}
	
	
	
}
