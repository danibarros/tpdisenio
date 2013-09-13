package edu.organizador.gui;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class VentanaDespedidaDecorator  implements VentanaDecoratorInterface{
	
	@Override
	public void dibujar() {
		JOptionPane.showMessageDialog(null,
				"Gracias por la compra!, vuelva pronto!");
		System.exit(0);
	}
}
