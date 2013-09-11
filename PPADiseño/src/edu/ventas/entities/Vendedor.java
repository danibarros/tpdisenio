package edu.ventas.entities;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Vendedor {
	
	private double precioFinal;
	private HashMap <Integer,Double> listaPrecios = new HashMap<Integer,Double>();
	
	public void vender(Map<String, List<Butaca>> seleccionados, Noche noche,int cantJubilados,int cantMenores, int cantMayores) {
		String key;
		List<Butaca> value;
		Iterator iterator = seleccionados.keySet().iterator();
		while (iterator.hasNext()) {
		    key = (String) iterator.next();
		    value = seleccionados.get(key);
		    
		    
		    	for (Butaca butaca : value) {
		    		calcularPrecio(key,noche,this.generarEntrada(butaca,noche),cantJubilados,cantMenores,cantMayores);
		    		if (cantJubilados >0){
		    			cantJubilados-=1;
		    			}
		    		
		    		else if(cantMenores>0){
		    			cantMenores-=1;
		    		}
		    		else if(cantMayores>0){
		    			cantMayores-=1;
		    		}
		    		listaPrecios.put(butaca.getNumero(),this.precioFinal);
			    }
		    }
		}
	private void calcularPrecio(String sector,Noche noche,Entrada entrada,Integer cantJubilados,Integer cantMenores,Integer cantMayores){ 
		Date fechaActual = new Date();
				
		this.precioFinal = entrada.calcularPrecioBase() + noche.precioDeLaNoche();
		if (cantJubilados >0){
			this.precioFinal = realizarDescuento("Jubilado",entrada);
			}
		else if(cantMenores>0){
			this.precioFinal = realizarDescuento("Menor",entrada);
			}
		else if(cantMayores>0){
			this.precioFinal = realizarDescuento("Mayor",entrada);
			}
				
		if (noche.getHoraInicio().getTime()- fechaActual.getTime() > 30 / (24 * 60 * 60 * 1000)){ 
			this.precioFinal = precioFinal - 100;
			} 
	}
	
	public Map<Integer,Double> getPrecio(){
		return listaPrecios;
		
	};
	
	private Entrada generarEntrada(Butaca butaca,Noche noche){
		
		
		int numeroEntrada = this.generarCodigo();
		Entrada entrada= new Entrada(numeroEntrada, butaca, noche);
		return entrada;
	};
	
	private double realizarDescuento(String tipo, Entrada entrada) {
		if (tipo == "Menor" & entrada.calcularPrecioBase() > 100) {
			return this.precioFinal * 0.8;

		} else if (tipo=="Menor" & entrada.calcularPrecioBase() > 50
				& entrada.calcularPrecioBase() < 100) {
			return this.precioFinal - 10;

		} else if (tipo=="Jubilado") {
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