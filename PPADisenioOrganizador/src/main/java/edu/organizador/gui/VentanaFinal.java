package edu.organizador.gui;

import java.awt.GridLayout;
import java.util.List;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import edu.core.entities.Banda;
import edu.core.entities.Entrada;
import edu.core.entities.Festival;
import edu.core.entities.Noche;
import edu.core.entities.Sector;
import edu.core.entities.Vendedor;

public class VentanaFinal implements VentanaDecoratorInterface{
	private Festival festival;
	private JPanel panel;
	private JFrame frame;
	
	public VentanaFinal(Festival festival, JFrame frame){
		this.festival = festival;
		this.frame = frame;
	}
	
	@Override
	public void dibujar() {	
		panel = new JPanel(new GridLayout(0, 2));
		panel.add(new JLabel("Festival :"));
		panel.add(new JLabel(festival.getNombre()));
		panel.add(new JLabel("Fecha de inicio :"));
		panel.add(new JLabel(String.valueOf(festival.getFechaInicio())));
		panel.add(new JLabel("Estadio :"));
		panel.add(new JLabel(festival.getEstadio().getNombre() + " " + festival.getEstadio().getLocalidad().getNombre()));
		List<Noche> noches = festival.getNoches();
		
		for (Noche noche : noches) {
			panel.add(new JLabel("Noche : "));
			panel.add(new JLabel(String.valueOf(noche.getNumero())));
			panel.add(new JLabel("Fecha :"));
			panel.add(new JLabel(String.valueOf(noche.getFecha())));
			panel.add(new JLabel("Hora inicio :"));
			panel.add(new JLabel(String.valueOf(noche.getHoraInicio())));
			informarBandas(noche, panel);
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
	}

	private void informarBandas(Noche noche, JPanel panel) {
		List<Banda> bandas = noche.getBandas();
		for (Banda banda : bandas) {
			panel.add(new JLabel("Banda :"));
			panel.add(new JLabel(banda.getNombre()));
		}
	}

}
