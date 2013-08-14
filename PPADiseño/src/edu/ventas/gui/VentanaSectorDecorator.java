package edu.ventas.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Spring;
import javax.swing.SpringLayout;

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
			if (sector2.getNombre().equals(sector)) {
				sectorEncontrado = sector2;
				break;
			}
		}
		List<Fila> filas = sectorEncontrado.getFilas();
		if (panel == null)
			panel = new JPanel();
		frame.setVisible(false);
		panel.removeAll();
		panel.setSize(frame.getWidth(), filas.size() * cutbutton.getHeight());
		int y = cutbutton.getHeight();
		for (Fila fila : filas) {
			dibujarFila(fila, frame);
		}
		frame.add(panel);
		frame.setVisible(true);
	}

	@Override
	public void dibujar() {
		// TODO Auto-generated method stub

	}

	private void dibujarFila(Fila fila, JFrame frame) {
		List<Butaca> butacas = fila.getButacas();
		JPanel panelFila = new JPanel();
		JButton cutbutton = null;
		for (Butaca butaca : butacas) {
			cutbutton = new JButton(new ImageIcon(
					"resources/ButacaNoDisponible.png"));
			panelFila.add(cutbutton);
			cutbutton.setBackground(Color.BLUE);
			ImageIcon press = new ImageIcon("resources/ButacaNoDisponible.png");
			cutbutton.setPressedIcon(press);
		}
		panelFila.setSize(panel.getWidth(), cutbutton.getHeight());
		panel.add(panelFila);
	}
}
