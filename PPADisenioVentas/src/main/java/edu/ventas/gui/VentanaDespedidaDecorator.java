package edu.ventas.gui;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import edu.ventas.controlador.Controlador;

public class VentanaDespedidaDecorator  implements VentanaDecoratorInterface{
	
	@Override
	public void dibujar() {
		JOptionPane.showMessageDialog(null,
				"Gracias por la compra!, vuelva pronto!");
		
		VentanaFormularioDecorator ventana = new VentanaFormularioDecorator();
		ventana.dibujar();
		
		
		

	}
}
