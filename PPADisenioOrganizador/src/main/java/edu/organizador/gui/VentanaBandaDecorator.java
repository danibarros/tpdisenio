package edu.organizador.gui;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.core.entities.Banda;
import external.utils.CheckComboBox;

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;

public class VentanaBandaDecorator implements VentanaDecoratorInterface {

	 Banda banda;

@Override
public void dibujar() {

}
	
@SuppressWarnings("unchecked")
public List<String> cargarFormularioBandas(){
	
	List<String> datos = new ArrayList<String>();
	Set<Object> options = new HashSet<>();
	options.add("Tan Bionica");
	options.add("Ciro y los persas");
	options.add("Iron Maden");
	options.add("Catupecu Machu");
	options.add("Metallica");
	@SuppressWarnings({ "unchecked", "rawtypes" })
	JComboBox<String> categoria = new JComboBox<String>();
	
	JPanel panel = new JPanel(new GridLayout(0, 1));
	Color c = new Color(112,173,208);
	panel.setBackground(c);
	CheckComboBox check = new CheckComboBox(options);
	panel.add(new JLabel("Ingrese nombre de la banda"));
	panel.add(check);
	
	panel.add(new JLabel("Ingrese Categoria de la Banda"));
	panel.add(categoria);
	categoria.addItem("Rock");
	categoria.addItem("Pop");
	categoria.addItem("Electronica");
	
	int result = JOptionPane.showConfirmDialog(null, panel, "Selección",
			 JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
	
	if (result == JOptionPane.OK_OPTION) { 
			if(check.getToolkit().equals("") || categoria.getToolkit().equals("")) { 
				VentanaAlertDecorator alert = new VentanaAlertDecorator();
				alert.dibujar();
				this.cargarFormularioBandas();
				}
			else{
				datos.addAll((Collection<? extends String>) check.getToolkit());
				datos.addAll((Collection<? extends String>) categoria.getToolkit());
				
				return datos;
				
				}
	}else{
		System.exit(0);
	
	}
	return datos;
	
	}
}