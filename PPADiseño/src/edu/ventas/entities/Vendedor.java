package edu.ventas.entities;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Vendedor {
	
	private double precioFinal;
	private HashMap <Integer,Double> listaPrecios = new HashMap<Integer,Double>();
	
	public void vender(Map<String, List<Butaca>> seleccionados, Noche noche,Integer edad,Integer cantJubilados,Integer cantMenores, Integer cantMayores) {
		String key;
		List<Butaca> value;
		Iterator iterator = seleccionados.keySet().iterator();
		while (iterator.hasNext()) {
		    key = (String) iterator.next();
		    value = seleccionados.get(key);
		    if(seleccionados.size() != (cantJubilados + cantMenores + cantMayores)){
		    	/*deberia hacer algo*/
		    }
		    for (Butaca butacas : value) {
		    	 if(cantJubilados != 0){ 
		    	 		edad = 70;
		    			cantJubilados = cantJubilados - 1;
		    	 }else if (cantMenores != 0){
		    			edad = 15;
		    			cantMenores = cantMenores - 1;
		    	 }else{
		    			edad = 25;
		    	 		cantMayores = cantMayores - 1;
		    			
		    	    
		    	  }
		    	this.calcularPrecio(key,noche,edad,this.generarEntrada(butacas,noche));
		    	for (Butaca butaca : value) {
		    		listaPrecios.put(butaca.getNumero(),this.precioFinal);
			    	 
				}
		    	 
				
				
			}
		    
		}	
		
	}

	private void calcularPrecio(String sector,Noche noche,Integer edad,Entrada entrada){ 
		Date fechaActual = new Date();
				
		this.precioFinal = entrada.calcularPrecioBase() + noche.precioDeLaNoche();
		this.precioFinal = realizarDescuento(edad,entrada);		
		if (noche.getHoraInicio().getTime()- fechaActual.getTime() > 30 / (24 * 60 * 60 * 1000))
			this.precioFinal = precioFinal - 100; 
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
