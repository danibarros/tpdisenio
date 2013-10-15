package edu.ventas.gui;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import edu.ventas.entities.PuntoDeVenta;
import edu.ventas.entities.Vendedor;

public class VentanaInicioDecorator {

	public void elegir(List<PuntoDeVenta> puntosDeVenta){
		List<String> items = new ArrayList<String>();
		items.add("Organizar");
		items.add("Vender");
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		JComboBox combo = new JComboBox(items.toArray());
		
		JPanel panel = new JPanel(new GridLayout(0, 1));
		
		
		panel.add(new JLabel("Seleccione Función"));
		panel.add(combo);
		
		int result = JOptionPane.showConfirmDialog(null, panel, "Selección",
			 JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		
		if(items.get(combo.getSelectedIndex()) != "Organizar"){
				return cargarFormulario(puntosDeVenta);
		}else{
			VentanaOrganizador organizador = new VentanaOrganizador();
			return organizador.cargarOrganizador();
		}
	}

	public List<String> cargarFormulario(List<PuntoDeVenta> puntosDeVenta) {
		List<String> items = new ArrayList<String>();
		List<String> datos = new ArrayList<String>();

		for (PuntoDeVenta puntoDeVenta : puntosDeVenta) {
			items.add(String.valueOf(puntoDeVenta.getNombre()));
		}
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		JComboBox combo = new JComboBox(items.toArray());
		JTextField field1 = new JTextField("");
		JPanel panel = new JPanel(new GridLayout(0, 1));
		
		panel.add(new JLabel("Ingrese su nombre de vendedor"));
		panel.add(field1);
		
		panel.add(new JLabel("Ingrese el Punto de venta"));
		panel.add(combo);
		
		int result = JOptionPane.showConfirmDialog(null, panel, "Datos del vendedor",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		
		if (result == JOptionPane.OK_OPTION) {
			if(field1.getText().equals("")){
				VentanaAlertDecorator alert = new VentanaAlertDecorator();
				alert.dibujar();
				this.cargarFormulario(puntosDeVenta);
			}
			char letra = "T";
			if(field1.getText.contains("0"){ letra = "F"; }
			if(field1.getText.contains("1"){ letra = "F"; }
			if(field1.getText.contains("2"){ letra = "F"; }
			if(field1.getText.contains("3"){ letra = "F"; }
			if(field1.getText.contains("4"){ letra = "F"; }
			if(field1.getText.contains("5"){ letra = "F"; }
			if(field1.getText.contains("6"){ letra = "F"; }
			if(field1.getText.contains("7"){ letra = "F"; }
			if(field1.getText.contains("8"){ letra = "F"; }
			if(field1.getText.contains("9"){ letra = "F"; }
			
			if(letra = "T"){
				datos.add(field1.getText());
				datos.add(items.get(combo.getSelectedIndex()));
			}else{
				VentanaAlertDecorator alert = new VentanaAlertDecorator();
				alert.dibujar();
				this.cargarFormulario(puntosDeVenta);
				}
		}else{
			System.exit(0);
			this.cargarFormulario(puntosDeVenta);
		}
		return datos;

	}
}
