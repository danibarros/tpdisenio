package edu.ventas.entities;

import java.util.Map;
import java.util.Random;

import edu.ventas.main.Main;

public class Vendedor {
	
	private void realizarDescuento(){
		
		
		
	}
	
	private int generarCodigo(){
		int numero = (int) Math.floor(Math.random()*(1-10000+1)+10000);
		return numero;
	}
	
	
	public boolean vender(String nombre,int edad,Butaca butaca,Fila fila,Sector sector,Festival festival, Noche noche,Map<String,Integer> listaCategorias){
		
		
		if (butaca.isDisponible()) {
			
			int numeroEntrada = this.generarCodigo();
			
			Entrada entrada = new Entrada(numeroEntrada,butaca ,fila,sector,123123,festival,noche,listaCategorias);
			
			System.out.println("piola negro!");
			
			
			System.out.println(entrada.getNumeroDeEntrada() + ", "+entrada.getCodigoDeBarra() +", "+ entrada.getPrecio());
			
			return true;
		}else {
			
			return false;
		}
		
	}

}
