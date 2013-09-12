package edu.ventas.gui;

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
	
	
	public void dibujardos() {
		JOptionPane.showMessageDialog(null,
				"Sus datos han sido guardados");
		System.exit(0);
	}

}
