package edu.ventas.gui;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaConButacasDecorator implements VentanaDecoratorInterface{

	@Override
	public void dibujar() {
		
		
	}
	
	public void elegirButacas() {
		 JFrame frame = new JFrame(
				 "Adding a Rollover and Pressed Icon to a JButton Component");
				 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				 JPanel panel = new JPanel();
				 frame.add(panel, BorderLayout.CENTER);
				 JButton cutbutton = new JButton(new
				 ImageIcon("resources/ButacaLibre.png"));
				 panel.add(cutbutton);
				 ImageIcon rollover = new ImageIcon("resources/ButacaOcupada.png");
				 cutbutton.setRolloverIcon(rollover);
				 ImageIcon press = new ImageIcon("resources/ButacaOcupada.png");
				 cutbutton.setPressedIcon(press);
				 frame.setSize(400, 400);
				 frame.setVisible(true);
	}
}
