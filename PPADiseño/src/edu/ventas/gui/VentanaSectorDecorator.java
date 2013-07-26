package edu.ventas.gui;

import java.awt.BorderLayout;
import java.awt.Frame;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.ventas.entities.Estadio;

public class VentanaSectorDecorator implements VentanaDecoratorInterface {
	JPanel panel;

	public void dibujarSector(JFrame frame, String sector, Estadio estadio) {
		if (panel == null) {
			panel = new JPanel();
			frame.add(panel, BorderLayout.SOUTH);
			JButton cutbutton = new JButton(new ImageIcon(
					"resources/ButacaLibre.png"));
			panel.add(cutbutton);
			ImageIcon rollover = new ImageIcon("resources/ButacaOcupada.png");
			cutbutton.setRolloverIcon(rollover);
			ImageIcon press = new ImageIcon("resources/ButacaOcupada.png");
			cutbutton.setPressedIcon(press);
		}else{
			frame.add(panel, BorderLayout.CENTER);
			JButton cutbutton = new JButton(new ImageIcon(
					"resources/ButacaLibre.png"));
			panel.add(cutbutton);
			ImageIcon rollover = new ImageIcon("resources/ButacaOcupada.png");
			cutbutton.setRolloverIcon(rollover);
			ImageIcon press = new ImageIcon("resources/ButacaOcupada.png");
			cutbutton.setPressedIcon(press);
		}

	}

	@Override
	public void dibujar() {
		// TODO Auto-generated method stub

	}

	public void elegirButacas() {

	}

}
