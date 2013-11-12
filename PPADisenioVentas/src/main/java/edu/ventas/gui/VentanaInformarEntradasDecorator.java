package edu.ventas.gui;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.core.dao.EntradaDAO;
import edu.core.dao.NocheDAO;
import edu.core.entities.Butaca;
import edu.core.entities.Entrada;
import edu.core.entities.Fila;
import edu.core.entities.Noche;
import edu.core.entities.Sector;
import edu.core.entities.Vendedor;

public class VentanaInformarEntradasDecorator implements
		VentanaDecoratorInterface {

	JPanel panel;
	JFrame frame;
	boolean vender = false;
	int numeroDeEntrada;
	
	
	public VentanaInformarEntradasDecorator(JFrame frame){
		this.frame = frame;
	}
	@Override
	public void dibujar() {
		// TODO Auto-generated method stub
	}

	public  boolean informarEntradas(Map<String,List<Butaca>> seleccionados, double precio, Noche noche,Integer cantJubilados,Integer cantMenores,Integer cantMayores,String festival) 
	{
		int cantLineas = 0;
		cantLineas += 2;
		Set<Entrada> entradas = new HashSet<Entrada>();
		Set<Entrada> paraConfirmarVenta = new HashSet<Entrada>();
		List<Sector> sectores = noche.getEstadio().getSectores();
		panel = new JPanel(new GridLayout(0, cantLineas));
		panel.add(new JLabel("Festival :"));
		panel.add(new JLabel(festival));
		panel.add(new JLabel("Noche:"));
		panel.add(new JLabel(String.valueOf(noche.getNumero())));

		for (Sector sector : sectores) {
			if(sector != null){
				if (seleccionados.containsKey(sector.getColor())) {
					panel.add(new JLabel("Sector:"));
					panel.add(new JLabel(sector.getColor()));

					cantLineas += 1;
					Vendedor vendedor = new Vendedor();
					entradas = vendedor.vender(seleccionados, noche,
							cantJubilados, cantMenores, cantMayores);
					imprimirSector(panel, seleccionados.get(sector.getColor()),
							entradas, sector.getColor());
					paraConfirmarVenta.addAll(entradas);
				}
			}
		}
		int result = JOptionPane.showConfirmDialog(null, panel, "Datos de la entrada",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		
		boolean toReturn ;
		
		if (result == JOptionPane.OK_OPTION) {
			VentanaDespedidaDecorator despedida = new VentanaDespedidaDecorator();
    		despedida.dibujar();
    		toReturn = true;
		} else{
			frame.getContentPane().removeAll();
			toReturn = false;
		}
		panel.setVisible(true);
		return 	toReturn;
	}
	
	private void imprimirSector(JPanel panel, List<Butaca> butacas,Set<Entrada> entradas,String sector)
	{
		Entrada entrada=null;;
		for (Butaca butaca : butacas) 
		{
			if(butaca.getFila().getSector().getColor() == sector)
			{
				panel.add(new JLabel("Butaca N°"+ String.valueOf(butaca.getNumero())));
				for (Entrada ent : entradas) {
					if (ent.getButaca()==butaca)
							entrada=ent;
				}
				panel.add(new JLabel("Precio: $" + entrada.getPrecioFinal()));
			}
		}
	}
}
