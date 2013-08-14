package edu.ventas.gui;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.ventas.entities.Butaca;
import edu.ventas.entities.Fila;
import edu.ventas.entities.Noche;

public class VentanaInformarEntradasDecorator implements
		VentanaDecoratorInterface {

	@Override
	public void dibujar() {
		// TODO Auto-generated method stub
	}

	public void informarEntradas(List<Fila> filas, double precio, Noche noche) {
		int cantLineas = 0;
		List<String> sectores = new ArrayList<String>(); 
		for (Fila fila : filas) {
			sectores.add(fila.getSector().getNombre());
			cantLineas += fila.getButacas().size() + 1;
		}
		
		cantLineas += 2;
		cantLineas += sectores.size();
		
		JPanel panel = new JPanel(new GridLayout(0, cantLineas));
		panel.add(new JLabel("Noche:"));
		panel.add(new JLabel(String.valueOf(noche.getNumeroDeNoches())));
		for (String sector : sectores) {
			panel.add(new JLabel("Sector:" + sector));
			for (Fila fila : filas) {
				if(fila.getSector().getNombre() == sector);
					imprimirFila(panel,fila);
			}	
		}
		
	}
	
	private void imprimirFila(JPanel panel, Fila fila){
		for (Butaca butaca : fila.getButacas()) {
			panel.add(new JLabel("Butaca N°"+ String.valueOf(butaca.getNumero())));	
		}
	}
}
