package edu.core.entities;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.mapping.Set;

import edu.core.dao.NocheDAO;

public class Vendedor {
	
	private int idVendedor;
	private String nombre;
	private String usuario;
	private String contrasenia;
	
	public HashMap <Integer,Double> listaPrecios = new HashMap<Integer,Double>();
	
	private PuntoDeVenta puntoDeVenta;
	
	
	public int getIdVendedor() {
		return idVendedor;
	}

	public void setIdVendedor(int idVendedor) {
		this.idVendedor = idVendedor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public PuntoDeVenta getPuntoDeVenta() {
		return puntoDeVenta;
	}

	public void setPuntoDeVenta(PuntoDeVenta puntoDeVenta) {
		this.puntoDeVenta = puntoDeVenta;
	}
	

	public HashSet<Entrada> vender(Map<String, List<Butaca>> seleccionados,Festival fest ,Noche noche,Integer cantJubilados,Integer cantMenores, Integer cantMayores) 
	{
		NocheDAO nocheDao = new NocheDAO();
		String key;
		List<Butaca> value;
		HashSet<Entrada> entradasGeneradas = new HashSet<Entrada>();
		Iterator iterator = seleccionados.keySet().iterator();
		while (iterator.hasNext()) {
		    key = (String) iterator.next();
		    value = seleccionados.get(key);
		    
		    for (Butaca butacas : value) 
		    {
		    	Entrada entrada = new Entrada( butacas, noche, nocheDao);
		    	 if(cantJubilados != 0)
		    	 { 
		    	 	cantJubilados--;
		    		this.listaPrecios.put(butacas.getNumero(),entrada.calcularPrecioJubilados());
		    	 }
		    	 else if (cantMenores != 0)
		    	 {
		    		 cantMenores--;
		    		this.listaPrecios.put(butacas.getNumero(),entrada.calcularPrecioMenores());
		    	 }
		    	 else
		    	 {
	    	 		cantMayores--;
	    	 		this.listaPrecios.put(butacas.getNumero(),entrada.calcularPrecio());
		    	 }
		    	 entradasGeneradas.add(entrada);
		    		
			}
		}	
		
	return entradasGeneradas;
	}
	


}
