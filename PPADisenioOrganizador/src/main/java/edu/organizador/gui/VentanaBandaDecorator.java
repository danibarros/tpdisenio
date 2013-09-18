package edu.organizador.gui;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.BorderLayout;

public class VentanaBanda implements VentanaDecoratorInterface {
	}
	
public List<String> cargarFormularioBandas(string nombreBanda){
	
	List<String> datos = new ArrayList<String>();
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	JTextField field1 = new JTextField("");
	JTextField field2 = new JTextField("");
	
	JPanel panel = new JPanel(new GridLayout(0, 1));
	
	panel.add(new JLabel("Ingrese Categoria de la Banda"));
	panel.add(field1);
	panel.add(new JLabel("Ingrese Id de la Banda"));
	panel.add(field2);
	
	if (result == JOptionPane.OK_OPTION) {
			if(field1.getText().equals("") || field2.getText().equals("")) { 
				datos = null;
				VentanaAlertDecorator alert = new VentanaAlertDecorator();
				alert.dibujar();
				this.cargarFormularioBandas(nombreBanda);
				}
			else{
				datos.add(nombreBanda);
				datos.add(field1.getText());
				datos.add(field2.getText());
				}
	else{
		this.cargarFormularioBandas(nombreBanda);
		}
	}
	return datos; /*aun falta almacenar estos datos*/
	
}