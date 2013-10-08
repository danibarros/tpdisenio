package edu.organizador.gui;

import javax.swing.JOptionPane;

public class VentanaAlertDecorator implements VentanaDecoratorInterface {

	@Override
	public void dibujar() {
		JOptionPane.showMessageDialog(null,
				"Complete los campos correctamente para poder continuar.");
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

