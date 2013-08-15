package edu.ventas.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.ventas.entities.Butaca;
import edu.ventas.entities.Fila;
import edu.ventas.entities.Noche;
import edu.ventas.entities.Sector;
import edu.ventas.entities.Vendedor;

public class VentanaInformarEntradasDecorator implements
		VentanaDecoratorInterface {

	JFrame frame;
	JPanel panel;
	
	public VentanaInformarEntradasDecorator(JFrame frame){
		this.frame = frame;
	}
	
	@Override
	public void dibujar() {
		// TODO Auto-generated method stub
	}

	public void informarEntradas(Map<String,List<Butaca>> seleccionados, double precio, Noche noche,Vendedor vendedor,Integer edad) {
		int cantLineas = 0;
		cantLineas += 2;
		frame.getContentPane().removeAll();
		
		List<Sector> sectores = noche.getEstadio().getSectores();
		panel = new JPanel(new GridLayout(0, cantLineas));
		panel.add(new JLabel("Noche:"));
		panel.add(new JLabel(String.valueOf(noche.getNumeroDeNoches())));
		frame.add(panel, BorderLayout.NORTH);
		for (Sector sector : sectores) {
			if (seleccionados.containsKey(sector.getNombre())){
				panel.add(new JLabel("Sector:" + sector.getNombre()));
				cantLineas += 1;
				vendedor.vender(seleccionados,noche,edad);
				imprimirSector(panel,seleccionados.get(sector.getNombre()));
			}
		}
		frame.setVisible(true);
		panel.setVisible(true);
	}
	
	private void imprimirSector(JPanel panel, List<Butaca> butacas){
		for (Butaca butaca : butacas) {
			panel.add(new JLabel("Butaca N°"+ String.valueOf(butaca.getNumero())));	
		}
	}
}
