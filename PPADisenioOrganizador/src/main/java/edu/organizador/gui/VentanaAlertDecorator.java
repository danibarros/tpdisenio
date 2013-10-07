package edu.organizador.gui;

import javax.swing.JOptionPane;

public class VentanaAlertDecorator implements VentanaDecoratorInterface {

	@Override
	public void dibujar() {
		JOptionPane.showMessageDialog(null,
				"No se haga el vivo y complete los campos correctamente!");
	}
	
	public void errorpass(){
		JOptionPane.showMessageDialog(null,
				"Contraseña Incorrecta!");
		}
	
	public void errorid(){
		JOptionPane.showMessageDialog(null,
				"Id Incorrecto!");
		}
}

