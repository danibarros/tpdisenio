package edu.ventas.gui;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.core.dao.FestivalDAO;
import edu.core.dao.NocheDAO;
import edu.core.entities.Festival;
import edu.core.entities.Noche;

public class VentanaFormularioDecorator implements VentanaDecoratorInterface {
	
	@Override
	public void dibujar() {

	}

	public List<String> cargarFormulario(List<Festival> festivales) {
	
		List<String> itemsFestival = new ArrayList<String>();
		List<String> itemsNoche = new ArrayList<String>();
		List<String> datos = new ArrayList<String>();
		
		for (Festival festival : festivales) {
			itemsFestival.add(String.valueOf(festival.getNombre()));
		}
		@SuppressWarnings({ "unchecked", "rawtypes" })
		JComboBox comboFestival = new JComboBox(itemsFestival.toArray());
		
		FestivalDAO festDAO = new FestivalDAO();
		for (Noche noche : festDAO.getFestivalByName(comboFestival.getSelectedItem().toString()).getNoches()){
			if (noche != null) {
				itemsNoche.add(String.valueOf(noche.getNumero()));
			}
		};
		
		JComboBox comboNoche = new JComboBox(itemsNoche.toArray());
		
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
		panel.add(new JLabel("Seleccione el festival"));
		panel.add(comboFestival);
		panel.add(new JLabel("Seleccione la noche"));
		panel.add(comboNoche);
		
		int result = JOptionPane.showConfirmDialog(null, panel, "Datos de Compra",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		
		if (result == JOptionPane.OK_OPTION) 
		{
			if(field1.getText().equals("")  || field3.getText().equals("") || field4.getText().equals("") || field5.getText().equals("")) 
			{ 
				datos = null;
				VentanaAlertDecorator alert = new VentanaAlertDecorator();
				alert.dibujar();
				this.cargarFormulario(festivales);
			}
			else
			{
				
				datos.add(field1.getText());
				datos.add(field3.getText());
				datos.add(field4.getText());
				datos.add(field5.getText());
				datos.add(itemsNoche.get(comboNoche.getSelectedIndex()));
				datos.add(itemsFestival.get(comboFestival.getSelectedIndex()));
				
			}
		} 
		else 
		{
			datos=null;
			
		}
		return datos;

	}
}
