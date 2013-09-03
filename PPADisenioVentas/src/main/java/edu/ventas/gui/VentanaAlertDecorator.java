package edu.ventas.gui;

import javax.swing.JOptionPane;

public class VentanaAlertDecorator implements VentanaDecoratorInterface {

	@Override
	public void dibujar() {
		JOptionPane.showMessageDialog(null,
				"No se haga el vivo y complete los campos correctamente!");
	}
}
