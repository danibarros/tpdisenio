package edu.organizador.gui;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class VentanaDespedidaDecorator  implements VentanaDecoratorInterface{
	
	@Override
	public void dibujar() {
		JOptionPane.showMessageDialog(null,
				"Se ha cargado el horario de la banda!!, si desea no cargar mas, a continuacion toque cancelar!");
		
	}
}
