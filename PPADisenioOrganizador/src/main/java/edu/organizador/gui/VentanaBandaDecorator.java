package edu.organizador.gui;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.core.entities.Banda;

import java.awt.Color;
import java.awt.BorderLayout;

public class VentanaBandaDecorator implements VentanaDecoratorInterface {

	Banda banda;

@Override
public void dibujar() {

}
	
public List<String> cargarFormularioBandas(){
	
	List<String> datos = new ArrayList<String>();
	@SuppressWarnings({ "unchecked", "rawtypes" })
	JTextField field1 = new JTextField("");
	JTextField field2 = new JTextField("");
	
	JPanel panel = new JPanel(new GridLayout(0, 1));
	
	panel.add(new JLabel("Ingrese nombre de la banda"));
	panel.add(field1);	
	panel.add(new JLabel("Ingrese Categoria de la Banda"));
	panel.add(field2);
	
	int result = JOptionPane.showConfirmDialog(null, panel, "Selección",
			 JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
	
	if (result == JOptionPane.OK_OPTION) { 
			if(field1.getText().equals("") || field2.getText().equals("")) { 
				VentanaAlertDecorator alert = new VentanaAlertDecorator();
				alert.dibujar();
				this.cargarFormularioBandas();
				}
			else{
				datos.add(field1.getText());
				datos.add(field2.getText());
				return datos; 
				}
	}else{
		System.exit(0);
	
	}
	return datos;
	
	}
}