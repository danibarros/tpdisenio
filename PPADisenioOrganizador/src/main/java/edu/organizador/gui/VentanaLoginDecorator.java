package edu.organizador.gui;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import edu.core.entities.Noche;

public class VentanaLoginDecorator {

	public List<String> login(){
		List<String> datos = new ArrayList<String>();
		JTextField field1 = new JTextField("");
		JPasswordField field2 = new JPasswordField("");
		JPanel panel = new JPanel(new GridLayout(0, 1));
		panel.add(new JLabel("Usuario"));
		panel.add(field1);
		panel.add(new JLabel("Contraseña"));
		panel.add(field2);
		int result = JOptionPane.showConfirmDialog(null, panel, "Datos de usuario",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		
		if (result == JOptionPane.OK_OPTION) {
			if(field1.getText().equals("") || field2.getPassword().equals("")) { 
				datos = null;
				VentanaAlertDecorator alert = new VentanaAlertDecorator();
				alert.dibujar();
				login();
			}else{
				datos.add(field1.getText());
				datos.add(String.copyValueOf(field2.getPassword()));
			}
		} else {
			System.exit(0);
		}
		return datos;
	}
	
}
