package edu.organizador.gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.core.dao.DataReader;
import edu.core.dao.DataReaderDAO;
import edu.core.entities.Banda;
import edu.core.entities.Butaca;
import edu.core.entities.Estadio;
import edu.core.entities.Fila;
import edu.core.entities.Noche;
import edu.core.entities.Sector;

public class VentanaNocheDecorator implements VentanaDecoratorInterface,
		ActionListener {
	JPanel panel;

	List<Butaca> seleccionados = new ArrayList<Butaca>();
	List<Sector> sectores;
	List<Fila> filas;

	public void formularioNoche(Noche noche, JFrame frame){
		
		List<String> items = new ArrayList<String>();
		DataReaderDAO dataReader = new DataReader();
		noche.getHoraInicio();
		
		if (panel == null)
			panel = new JPanel();
		frame.setVisible(false);
		panel.removeAll();
		
		Set<Banda> bandas = new HashSet<Banda>();
		for (Banda banda : bandas) {
			items.add(banda.getNombre());
		}
		items.add("ninguna");
		
		JComboBox<String> comboBandas = new JComboBox<String>(items.toArray());
		
		comboBandas.setName("cmbBandas");
		comboBandas.addActionListener(this);
		
		panel.add(comboBandas);
		if(items.get(comboBandas.getSelectedIndex()) != "ninguna"){
			VentanaBandasDecorator ventana = new VentanaBandasDecorator();
			ventana.cargarFormularioBandas((items.get(comboBandas.getSelectedIndex()));
		}  
		else{
			System.exit(0);
			}
		
		frame.add(panel);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dibujar() {
		// TODO Auto-generated method stub
		
	}
}
