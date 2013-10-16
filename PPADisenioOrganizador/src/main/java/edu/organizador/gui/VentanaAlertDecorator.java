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
	
	public void datoNoNumerio(String dato){
		JOptionPane.showMessageDialog(null,
				"El dato ingresado "+dato+ " debe ser numerico");
		}
	
	public void datoNumerio(String dato){
		JOptionPane.showMessageDialog(null,
				"El dato ingresado "+dato+ " no debe ser numerico");
		}
}

