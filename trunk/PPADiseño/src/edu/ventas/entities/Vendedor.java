package edu.ventas.entities;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Vendedor {
	
	public void vender(Map<String, List<Butaca>> seleccionados, Noche noche,Integer edad) {
		String key;
		List<Butaca> value;
		Iterator iterator = seleccionados.keySet().iterator();
		while (iterator.hasNext()) {
		    key = (String) iterator.next();
		    value = seleccionados.get(key);
		    
		    for (Butaca butaca : value) {
		    	
		    	this.calcularPrecio(key,noche,edad,this.generarEntrada(butaca));
				
				
			}
		    
		}	
		
	}

	private double calcularPrecio(String sector,Noche noche,Integer edad,Entrada entrada){
		
		double precioFinal = entrada.calcularPrecioBase() + noche.precioDeLaNoche() - this.realizarDescuento(edad,entrada);

		return precioFinal;
		
	}
				
	private Entrada generarEntrada(Butaca butaca){
		
		Entrada entrada=null;
		int numeroEntrada = this.generarCodigo();
		return entrada;
	};
	
	private double realizarDescuento(int edad, Entrada entrada) {
		if (edad < 18 & entrada.calcularPrecioBase() > 100) {
			return entrada.getPrecio() * 0.8;

		} else if (edad < 18 & entrada.calcularPrecioBase() > 50
				& entrada.calcularPrecioBase() < 100) {
			return entrada.getPrecio() - 10;

		} else if (edad > 65) {
			return entrada.getPrecio() * 0.85;

		} else {
			return entrada.getPrecio();
		}

	}

	private int generarCodigo() {
		int numero = (int) Math.floor(Math.random() * (1 - 10000 + 1) + 10000);
		return numero;
	}


}
