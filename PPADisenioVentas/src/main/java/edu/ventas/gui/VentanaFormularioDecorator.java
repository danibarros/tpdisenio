package edu.ventas.gui;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.core.entities.Noche;

public class VentanaFormularioDecorator implements VentanaDecoratorInterface {
	
	@Override
	public void dibujar() {

	}

	public List<String> cargarFormulario(List<Noche> noches) {
	
		List<String> items = new ArrayList<String>();
		List<String> datos = new ArrayList<String>();
		
		for (Noche noche : noches) {
			items.add(String.valueOf(noche.getNumero()));
		}
		@SuppressWarnings({ "unchecked", "rawtypes" })
		JComboBox combo = new JComboBox(items.toArray());
		JTextField field1 = new JTextField("");
		
		JTextField field3 = new JTextField("");
		JTextField field4 = new JTextField("");
		JTextField field5 = new JTextField("");
		JPanel panel = new JPanel(new GridLayout(0, 1));

		panel.add(new JLabel("Ingrese su nombre y apellido"));
		panel.add(field1);
		
		panel.add(new JLabel("Ingrese Cantidad De Jubilados"));
    	panel.add(field3);
		panel.add(new JLabel("Ingrese Cantidad De Menores"));
		panel.add(field4);
    	panel.add(new JLabel("Ingrese Cantidad De Mayores"));
		panel.add(field5);
		panel.add(new JLabel("Ingrese una noche"));
		panel.add(combo);
		
		int result = JOptionPane.showConfirmDialog(null, panel, "Datos del comprador",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		
		if (result == JOptionPane.OK_OPTION) 
		{
			if(field1.getText().equals("")  || field3.getText().equals("") || field4.getText().equals("") || field5.getText().equals("")) 
			{ 
				datos = null;
				VentanaAlertDecorator alert = new VentanaAlertDecorator();
				alert.dibujar();
				this.cargarFormulario(noches);
			}
			else
			{
				
				datos.add(field1.getText());
				
				datos.add(field3.getText());
				datos.add(field4.getText());
				datos.add(field5.getText());
				datos.add(items.get(combo.getSelectedIndex()));
				
			}
		} 
		else 
		{
			this.cargarFormulario(noches);
		}
		return datos;

	}
}
