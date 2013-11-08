package edu.ventas.gui;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.core.entities.Butaca;
import edu.core.entities.Fila;
import edu.core.entities.Noche;
import edu.core.entities.Sector;
import edu.core.entities.Vendedor;

public class VentanaInformarEntradasDecorator implements
		VentanaDecoratorInterface {

	JPanel panel;
	JFrame frame;
	boolean vender = false;
	
	
	public VentanaInformarEntradasDecorator(JFrame frame){
		this.frame = frame;
	}
	@Override
	public void dibujar() {
		// TODO Auto-generated method stub
	}

	public boolean informarEntradas(Map<String,List<Butaca>> seleccionados, double precio, Noche noche,Vendedor vendedor,Integer edad,Integer cantJubilados,Integer cantMenores,Integer cantMayores,String festival) {
		int cantLineas = 0;
		cantLineas += 2;
		
		List<Sector> sectores = noche.getEstadio().getSectores();
		panel = new JPanel(new GridLayout(0, cantLineas));
		panel.add(new JLabel("Festival :"));
		panel.add(new JLabel(festival));
		panel.add(new JLabel("Noche:"));
		panel.add(new JLabel(String.valueOf(noche.getNumero())));

		for (Sector sector : sectores) {
			if (seleccionados.containsKey(sector.getColor())){
				panel.add(new JLabel("Sector:" + sector.getColor()));
				
				cantLineas += 1;
				vendedor.vender(seleccionados,noche,edad,cantJubilados,cantMenores,cantMayores);
				imprimirSector(panel,seleccionados.get(sector.getColor()),vendedor,sector.getColor());
			}
		}
		int result = JOptionPane.showConfirmDialog(null, panel, "Datos de la entrada",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		
		if (result == JOptionPane.OK_OPTION) {
			VentanaDespedidaDecorator despedida = new VentanaDespedidaDecorator();
    		despedida.dibujar();
		} else{
			frame.getContentPane().removeAll();
		}
		panel.setVisible(true);
		return vender;
	}
	
	private void imprimirSector(JPanel panel, List<Butaca> butacas,Vendedor vendedor,String sector){
		for (Butaca butaca : butacas) {
			if(butaca.getFila().getSector().getColor() == sector){
			panel.add(new JLabel("Butaca N°"+ String.valueOf(butaca.getNumero())));
			panel.add(new JLabel("Precio: $" + vendedor.getPrecio().get(butaca.getNumero())));
			}
		}
	}
}
