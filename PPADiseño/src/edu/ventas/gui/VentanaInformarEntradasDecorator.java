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

import edu.ventas.entities.Butaca;
import edu.ventas.entities.Fila;
import edu.ventas.entities.Noche;
import edu.ventas.entities.Sector;
import edu.ventas.entities.Vendedor;

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

	public boolean informarEntradas(Map<String,List<Butaca>> seleccionados, double precio, Noche noche,Vendedor vendedor,int cantJubilados,int cantMenores,int cantMayores) {
		int cantLineas = 0;
		cantLineas += 2;
		
		List<Sector> sectores = noche.getEstadio().getSectores();
		panel = new JPanel(new GridLayout(0, cantLineas));
		panel.add(new JLabel("Noche:"));
		panel.add(new JLabel(String.valueOf(noche.getNumeroDeNoches())));

		for (Sector sector : sectores) {
			if (seleccionados.containsKey(sector.getNombre())){
				panel.add(new JLabel("Sector:" + sector.getNombre()));
				
				cantLineas += 1;
				vendedor.vender(seleccionados,noche,cantJubilados,cantMenores,cantMayores);
				imprimirSector(panel,seleccionados.get(sector.getNombre()),vendedor,sector.getNombre());
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
			if(butaca.getFila().getSector().getNombre() == sector){
			panel.add(new JLabel("Butaca N�"+ String.valueOf(butaca.getNumero())));
			panel.add(new JLabel("Precio: $" + vendedor.getPrecio().get(butaca.getNumero())));
			}
		}
	}
}
