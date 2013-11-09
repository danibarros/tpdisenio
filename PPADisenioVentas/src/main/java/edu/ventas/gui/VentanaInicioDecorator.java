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

import edu.core.dao.PuntoDeVentaDAO;
import edu.core.dao.VendedorDAO;
import edu.core.entities.PuntoDeVenta;
import edu.core.entities.Vendedor;

public class VentanaInicioDecorator {

	public Integer cargarFormulario(Vendedor vendedor) {
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		
		
		
		JPanel panel = new JPanel(new GridLayout(0, 1));
		
		panel.add(new JLabel("Bienvenido: "+vendedor.getNombre()));
		
		PuntoDeVentaDAO puntoVentaDao = new PuntoDeVentaDAO();
		
		PuntoDeVenta puntoVenta = puntoVentaDao.getPuntoDeVentaById(vendedor.getPuntoDeVenta().getIdPunto());
		
		panel.add(new JLabel("Usted esta en el punto de Venta: "+ puntoVenta.getNombre()));
		
		
		int result = JOptionPane.showConfirmDialog(null, panel, "Datos del vendedor",
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
		
		
		return result;

	}
}
