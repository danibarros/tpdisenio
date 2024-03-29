package edu.ventas.gui;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class VentanaOrganizador implements VentanaDecoratorInterface {

	@Override
	public void dibujar() {
		// TODO Auto-generated method stub
		
	}
	
	public List<String> cargarOrganizador() {
		
		List<String> datos = new ArrayList<String>();
		
		JTextField field1 = new JTextField("");
		JTextField field2 = new JTextField("");
		JTextField field3 = new JTextField("");
		JPanel panel = new JPanel(new GridLayout(0, 1));

		panel.add(new JLabel("Ingrese la banda que desea"));
		panel.add(field1);
		panel.add(new JLabel("Ingrese el horario de inicio"));
    	panel.add(field2);
		panel.add(new JLabel("Ingrese el Estadio"));
		panel.add(field3);
		
		int result = JOptionPane.showConfirmDialog(null, panel, "Datos del comprador",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		
		if (result == JOptionPane.OK_OPTION) {
			if(field1.getText().equals("") || field2.getText().equals("") || field3.getText().equals("") ) { 
				datos = null;
				VentanaAlertDecorator alert = new VentanaAlertDecorator();
				alert.dibujar();
			}else{
			datos.add(field1.getText());
			datos.add(field2.getText());
			datos.add(field3.getText());
			}
		} else {
		
		}
		return datos;
	}
}



