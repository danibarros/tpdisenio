package edu.organizador.gui;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class VentanaDespedidaDecorator  implements VentanaDecoratorInterface{
	
	@Override
	public void dibujar() {
		
		JOptionPane.showMessageDialog(null,
				"El Festival ha sido organizado con exito!");
		
	}
}
