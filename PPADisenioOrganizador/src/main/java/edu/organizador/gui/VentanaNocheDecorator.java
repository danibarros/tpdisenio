package edu.organizador.gui;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

import edu.core.dao.DataReader;
import edu.core.dao.DataReaderDAO;
import edu.core.entities.Banda;
import edu.core.entities.Butaca;
import edu.core.entities.Fila;
import edu.core.entities.Noche;
import edu.core.entities.Sector;
import edu.organizador.controlador.Controlador;
import external.utils.CheckComboBox;


import java.awt.Color;

public class VentanaNocheDecorator implements VentanaDecoratorInterface,
		ActionListener {
	JPanel panel;
	JFrame frame;
	List<Butaca> seleccionados = new ArrayList<Butaca>();
	List<Sector> sectores;
	List<Fila> filas;
	

	public void formularioNoche(Noche noche, JFrame frame){
		
		DataReaderDAO dataReader = new DataReader();
		noche.getHoraInicio();
		
		if (panel == null)
			panel = new JPanel(new GridBagLayout());
		frame.setVisible(false);
		panel.removeAll();
		List<Banda> bandas = dataReader.getBandas();
		Set<Object> options = new HashSet<>();
		for (Banda banda : bandas) {
			options.add(banda.getNombre());
		}
		Color c = new Color(112,173,208);
		panel.setBackground(c);
		CheckComboBox check = new CheckComboBox(options);
		JComboBox<String> estadios = new JComboBox<String>();
		
		estadios.addItem("River");
		estadios.addItem("Boca");
		
		JPanel grid = new JPanel(new GridLayout(0,1));
		
		check.setName("cmbBandas");
		check.addActionListener(this);
		grid.add(new JLabel("Elija el estadio"));
		grid.add(estadios);
		grid.add(new JLabel("Elija las bandas que desea"));
		grid.add(check);
		grid.add(new JLabel("Ingrese hora de inicio"));
		JButton button = new JButton();
		SpinnerDateModel model = new SpinnerDateModel();
		model.setCalendarField(Calendar.MINUTE);
		
		
		
		JPanel pnlBottom = new JPanel();
		frame.add(pnlBottom, BorderLayout.SOUTH);
		JButton btnComprar = new JButton();
		btnComprar.setName("btnBandas");
		btnComprar.setText("Formulario de Bandas");
		btnComprar.addActionListener(this);
		pnlBottom.add(btnComprar, BorderLayout.NORTH);
		
		JSpinner spinner= new JSpinner();
		spinner.setModel(model);
		spinner.setEditor(new JSpinner.DateEditor(spinner, "h:mm a"));
		grid.add(spinner);
		panel.add(grid);
		frame.add(panel, BorderLayout.CENTER);
		frame.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String event = e.getActionCommand();
		switch (event) {
		case "Formulario de Bandas":
			Controlador controlador = new Controlador(frame);
			VentanaBandaDecorator ventana = new VentanaBandaDecorator();
			List<String> datos = ventana.cargarFormularioBandas();
			controlador.guardarBanda(datos);
			break;
		default:
			break;
		}
		
	}

	@Override
	public void dibujar() {
		// TODO Auto-generated method stub
		
	}
	
}
