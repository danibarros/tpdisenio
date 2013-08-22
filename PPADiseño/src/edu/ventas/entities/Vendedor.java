package edu.ventas.entities;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Vendedor {
	
	private double precioFinal;
	private HashMap <Integer,Double> listaPrecios = new HashMap<Integer,Double>();
	
	public void vender(Map<String, List<Butaca>> seleccionados, Noche noche,Integer edad,Integer fechaCompra) {
		String key;
		List<Butaca> value;
		Iterator iterator = seleccionados.keySet().iterator();
		while (iterator.hasNext()) {
		    key = (String) iterator.next();
		    value = seleccionados.get(key);
		    
		    for (Butaca butacas : value) {
		    	
		    	this.calcularPrecio(key,noche,edad,this.generarEntrada(butacas,noche),fechaCompra);
		    	for (Butaca butaca : value) {
		    		listaPrecios.put(butaca.getNumero(),this.precioFinal);
			    	 System.out.println("Hola");
				}
		    	 
				
				
			}
		    
		}	
		
	}

	private void calcularPrecio(String sector,Noche noche,Integer edad,Entrada entrada,Integer fechaCompra){ //Esto es nuevo
		private int fecha; // Esto es nuevo 
		this.fecha = noche.getFecha(); // Esto es nuevo
		
		this.precioFinal = entrada.calcularPrecioBase() + noche.precioDeLaNoche();
		this.precioFinal = realizarDescuento(edad,entrada);		
		if (fecha - fechaCompra > 30) //Esto es nuevo
			this.precioFinal = precioFinal - 100; //Esto es nuevo, nose cuanto es el descuento por anticipada
	}
	
	public Map<Integer,Double> getPrecio(){
		return listaPrecios;
		
	};
	
	private Entrada generarEntrada(Butaca butaca,Noche noche){
		
		
		int numeroEntrada = this.generarCodigo();
		Entrada entrada= new Entrada(numeroEntrada, butaca, noche);
		return entrada;
	};
	
	private double realizarDescuento(int edad, Entrada entrada) {
		if (edad < 18 & entrada.calcularPrecioBase() > 100) {
			return this.precioFinal * 0.8;

		} else if (edad < 18 & entrada.calcularPrecioBase() > 50
				& entrada.calcularPrecioBase() < 100) {
			return this.precioFinal - 10;

		} else if (edad > 65) {
			return this.precioFinal * 0.85;

		} else {
			return this.precioFinal;
		}

	}

	private int generarCodigo() {
		int numero = (int) Math.floor(Math.random() * (1 - 10000 + 1) + 10000);
		return numero;
	}


}
