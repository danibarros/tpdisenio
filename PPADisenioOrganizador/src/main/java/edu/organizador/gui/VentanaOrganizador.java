package edu.organizador.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.core.dao.BandaDAO;
import edu.core.entities.Banda;


public class VentanaOrganizador implements VentanaDecoratorInterface {
	JFrame frame;
	List<String> datos = new ArrayList<String>();
	@Override
	public void dibujar() {
		// TODO Auto-generated method stub
		
	}
	
	public List<String> cargarOrganizador() {
		

		JTextField field3 = new JTextField("");
		JTextField field4 = new JTextField("");
		JPanel panel = new JPanel(new GridLayout());
		Color c = new Color(112, 173, 208);
		panel.setBackground(c);
		

		BandaDAO bandaDao = new BandaDAO();
		
		JComboBox<String> cmbBandas = new JComboBox<String>();
		Set<Banda> bandas = bandaDao.findAll();
		
		for (Banda banda : bandas) {
				cmbBandas.addItem(banda.getNombre());
		}
		
		panel.add(new JLabel("Seleccione la banda"));
		panel.add(cmbBandas);
		cmbBandas.addItem("river");
		panel.add(new JLabel("Ingrese el horario de inicio"));
    	panel.add(field3);
		
		
		int result = JOptionPane.showConfirmDialog(null, panel, "Datos de Diagramación",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		
		if (result == JOptionPane.OK_OPTION) {
			if(field3.getText().equals("")|| field4.getText().equals("") ) { 
				datos = null;
				VentanaAlertDecorator alert = new VentanaAlertDecorator();
				alert.dibujar();
				this.cargarOrganizador();
			}else{
			datos.add((String) cmbBandas.getSelectedItem());
			datos.add(field3.getText());
			
			VentanaDespedidaDecorator despedida = new VentanaDespedidaDecorator();
			despedida.dibujar();
			this.cargarOrganizador();
			
			}
		} else {
			JOptionPane.showMessageDialog(null,
					"Se ha realizado la diagramacion del festival, muchas gracias!!");
			
		}
		return datos;
	}
}

