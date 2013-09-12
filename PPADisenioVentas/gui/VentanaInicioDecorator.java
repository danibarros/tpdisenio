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

	public List<String> elegir(List<PuntoDeVenta> puntosDeVenta){
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
			datos.add(field1.getText());
			datos.add(items.get(combo.getSelectedIndex()));
		} else {
			this.cargarFormulario(puntosDeVenta);
		}
		return datos;

	}
}
