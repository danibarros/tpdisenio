package edu.ventas.gui;

import javax.swing.JOptionPane;

public class VentanaAlertDecorator implements VentanaDecoratorInterface {

	@Override
	public void dibujar() {
		JOptionPane.showMessageDialog(null,
				"No se haga el vivo y complete los campos correctamente!");
	}
	
	public void errorid(){
		JOptionPane.showMessageDialog(null,
				"Usuario o contraseña incorrectos");
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
