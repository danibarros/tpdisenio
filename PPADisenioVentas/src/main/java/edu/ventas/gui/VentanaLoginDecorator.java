package edu.ventas.gui;

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
import edu.core.requests.UserValidationRequest;
import edu.ventas.gui.VentanaAlertDecorator;

public class VentanaLoginDecorator {

	public UserValidationRequest login(){
		UserValidationRequest request = new UserValidationRequest();
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
				VentanaAlertDecorator alert = new VentanaAlertDecorator();
				alert.dibujar();
				login();
			}else{
				char[] input = field2.getPassword();
				String id = field1.getText();
				request.setUser(id);
				request.setPass(String.valueOf(input));
			}
		   }else{
			System.exit(0);
		}
		return request;
	}
	
}
