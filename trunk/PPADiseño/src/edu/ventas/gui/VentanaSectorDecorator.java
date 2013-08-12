package edu.ventas.gui;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.ventas.entities.Butaca;
import edu.ventas.entities.Estadio;
import edu.ventas.entities.Fila;
import edu.ventas.entities.Sector;

public class VentanaSectorDecorator implements VentanaDecoratorInterface {
	JPanel panel;

	public void dibujarSector(JFrame frame, String sector, Estadio estadio) {
		JButton cutbutton = new JButton(new ImageIcon(
				"resources/ButacaNoDisponible.png"));
		List<Sector> sectores = estadio.getSectores();
		Sector sectorEncontrado = null;
		for (Sector sector2 : sectores) {
			if (sector2.getNombre().equals(sector)){
				sectorEncontrado = sector2;
				break;					
			}
		}
		List<Fila> filas = sectorEncontrado.getFilas();
		if (panel == null)
			panel = new JPanel(new GridLayout(0,filas.size()));
		frame.setVisible(false);
		panel.removeAll();
		int y = cutbutton.getHeight();
		for (Fila fila : filas) {
			dibujarFila(y,fila, frame);
			y += cutbutton.getHeight();
		}
		frame.add(panel, BorderLayout.CENTER);
		frame.setVisible(true);
	}

	@Override
	public void dibujar() {
		// TODO Auto-generated method stub

	}

	public void elegirButacas() {

	}
	
	private void dibujarFila(int y, Fila fila, JFrame frame){
		List<Butaca> butacas = fila.getButacas();
		int x,i;
		x = 10;
		i = 10;
		JPanel panelFila = new JPanel();
		for (Butaca butaca : butacas) {
			JButton cutbutton = new JButton(new ImageIcon(
					"resources/ButacaNoDisponible.png"));
			cutbutton.setBounds(x +i,y,cutbutton.getWidth(),cutbutton.getHeight());
			panelFila.add(cutbutton);
			ImageIcon press = new ImageIcon("resources/ButacaNoDisponible.png");
			cutbutton.setPressedIcon(press);
			i+=20;
		}
		panel.add(panelFila);
	}

}
