package edu.organizador.controlador;

import edu.core.entities.Festival;
import edu.organizador.gui.Ventana;
import edu.organizador.gui.VentanaDecoratorInterface;

public class VentanaFinal implements VentanaDecoratorInterface{
	private Festival festival;
	
	public VentanaFinal(Festival festival){
		this.festival = festival;
	}
	
	@Override
	public void dibujar() {	
		
	}

}
